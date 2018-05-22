package parqueadero.dominio.servicio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parqueadero.dominio.excepcion.ParquearException;
import parqueadero.dominio.modelo.Calendario;
import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.persistencia.repositorio.RepositorioParqueoPersistente;

@Service
public class ServiciosVigilante {

	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_HORA_MOTO = 500;
	public static final int VALOR_DIA_CARRO = 8000;
	public static final int VALOR_DIA_MOTO = 4000;
	public static final int LIMITE_CARROS = 20;
	public static final int LIMITE_MOTOS = 10;

	public static final String VEHICULO_NO_AUTORIZADO = "NO ESTA AUTORIZADO A INGRESAR";
	public static final String LIMITE_DE_CARROS = "EL CUPO DE CARROS SE ENCUENTRA LLENO";
	public static final String LIMITE_DE_MOTOS = "EL CUPO DE MOTOS SE ENCUENTRA LLENO";

	private RepositorioParqueoPersistente repositorioParqueo;
	private Calendario calendario;

	@Autowired
	public ServiciosVigilante(RepositorioParqueoPersistente repositorioParqueo, Calendario calendario) {
		super();
		this.repositorioParqueo = repositorioParqueo;
		this.calendario = calendario;
	}

	public Parqueo registrarIngresoVehiculo(Vehiculo vehiculo) {
		hayEspaciosDisponibles(vehiculo.getTipo());
		return generarIngresoVehiculo(vehiculo, calendario.getFecha().getTime());
	}

	public Parqueo generarIngresoVehiculo(Vehiculo vehiculo, Date fechaIngreso) {
		return repositorioParqueo.guardarParqueo(new Parqueo(vehiculo, fechaIngreso));
	}

	public boolean estaParqueado(Vehiculo vehiculo) {
		return (repositorioParqueo.obtenerParqueoPorPlaca(vehiculo.getPlaca()) != null);
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
}
