package parqueadero.dominio.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import parqueadero.dominio.excepcion.ParquearException;
import parqueadero.dominio.modelo.Calendario;
import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Tiquete;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.persistencia.repositorio.RepositorioParqueoPersistente;
import parqueadero.persistencia.repositorio.RepositorioTiquetePersistente;

@Component
public class Vigilante {

	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_HORA_MOTO = 500;
	public static final int VALOR_DIA_CARRO = 8000;
	public static final int VALOR_DIA_MOTO = 4000;
	public static final int VALOR_MOTO_ALTO_CILINDRAJE = 2000;
	public static final int MOTO_ALTO_CILINDRAJE = 500;
	public static final int HORAS_MINIMO_DIA = 9;
	public static final int HORAS_MAXIMO_DIA = 24;
	public static final int LIMITE_CARROS = 20;
	public static final int LIMITE_MOTOS = 10;
	public static final String VEHICULO_NO_AUTORIZADO = "NO ESTA AUTORIZADO A INGRESAR HOY";
	public static final String VEHICULO_YA_PARQUEADO = "LA PLACA DEL VEHICULO YA SE ENCUENTRA DENTRO";
	public static final String LIMITE_DE_CARROS = "EL CUPO DE CARROS SE ENCUENTRA LLENO";
	public static final String LIMITE_DE_MOTOS = "EL CUPO DE MOTOS SE ENCUENTRA LLENO";

	private RepositorioParqueoPersistente repositorioParqueo;
	private RepositorioTiquetePersistente repositorioTiquete;
	private Calendario calendario;

	@Autowired
	public Vigilante(RepositorioParqueoPersistente repositorioParqueo, RepositorioTiquetePersistente repositorioTiquete,
			Calendario calendario) {
		super();
		this.repositorioParqueo = repositorioParqueo;
		this.repositorioTiquete = repositorioTiquete;
		this.calendario = calendario;
	}

	public Parqueo generarIngresoVehiculo(Vehiculo vehiculo) {
		return repositorioParqueo.guardarParqueo(new Parqueo(vehiculo, calendario.obtenerFechaActual()));
	}

	public void noEstaParqueado(String placa) {
		try {
			if (repositorioParqueo.obtenerParqueoPorPlaca(placa) != null) {
				throw new ParquearException(VEHICULO_YA_PARQUEADO);
			}
		} catch (NullPointerException e) {
			// Nada
		}
	}

	public void placaNoTieneRestriccionDia(String placa) {
		if (placa.startsWith("A") && !calendario.esDiaHabil()) {
			throw new ParquearException(VEHICULO_NO_AUTORIZADO);
		}
	}

	public void hayEspaciosDisponibles(String tipoVehiculo) {
		if (tipoVehiculo.equalsIgnoreCase("carro")
				&& repositorioParqueo.contadorParqueosPorTipo(tipoVehiculo) >= LIMITE_CARROS) {
			throw new ParquearException(LIMITE_DE_CARROS);
		}
		if (tipoVehiculo.equalsIgnoreCase("moto")
				&& repositorioParqueo.contadorParqueosPorTipo(tipoVehiculo) >= LIMITE_MOTOS) {
			throw new ParquearException(LIMITE_DE_MOTOS);
		}
	}

	public List<Parqueo> consultarVehiculosIngresados() {
		return repositorioParqueo.obtenerTodosParqueados();
	}

	public Tiquete generarTiquete(String placa) {
		Parqueo parqueo = repositorioParqueo.obtenerParqueoPorPlaca(placa);
		Date fechaSalida = calendario.obtenerFechaActual();
		return new Tiquete(parqueo.getVehiculo().getPlaca(), parqueo.getVehiculo().getTipo(),
				parqueo.getVehiculo().getCilindraje(), parqueo.getFechaIngreso(), fechaSalida,
				calcularCostoParqueo(parqueo, fechaSalida));
	}

	public int calcularCostoParqueo(Parqueo parqueo, Date fechaSalida) {
		int numeroHoras = calendario.diferenciaEnHoras(parqueo.getFechaIngreso(), fechaSalida);
		int numeroDias = 0;
		int totalCostoParqueo;
		if (numeroHoras >= HORAS_MAXIMO_DIA) {
			numeroDias = numeroHoras / 24;
			numeroHoras = numeroHoras - numeroDias * 24;
		}
		if (numeroHoras >= HORAS_MINIMO_DIA && numeroHoras <= HORAS_MAXIMO_DIA) {
			numeroDias += 1;
			numeroHoras = 0;
		}
		if (parqueo.getVehiculo().getTipo().equalsIgnoreCase("carro")) {
			totalCostoParqueo = VALOR_DIA_CARRO * numeroDias + VALOR_HORA_CARRO * numeroHoras;
		} else {
			totalCostoParqueo = VALOR_DIA_MOTO * numeroDias + VALOR_HORA_MOTO * numeroHoras;
			if (parqueo.getVehiculo().getCilindraje() > MOTO_ALTO_CILINDRAJE) {
				totalCostoParqueo += VALOR_MOTO_ALTO_CILINDRAJE;
			}
		}
		return totalCostoParqueo;
	}

	public Tiquete guardarTiquete(String placa) {
		Tiquete tiquete = generarTiquete(placa);
		repositorioParqueo.retirarParqueo(repositorioParqueo.obtenerParqueoEntidadPorPlaca(placa));
		repositorioTiquete.guardarTiquete(tiquete);
		return tiquete;
	}

}