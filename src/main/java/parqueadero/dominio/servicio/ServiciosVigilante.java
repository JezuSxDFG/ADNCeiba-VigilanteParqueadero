package parqueadero.dominio.servicio;

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
	public static final String LIMITE_DE_VEHICULOS = "EL PARQUEADERO SE ENCUENTRA LLENO";
	
	private RepositorioParqueoPersistente repositorioParqueo;
	private Calendario calendario;

	@Autowired
	public ServiciosVigilante(RepositorioParqueoPersistente repositorioParqueo, Calendario calendario) {
		super();
		this.repositorioParqueo = repositorioParqueo;
		this.calendario = calendario;
	}

	public Parqueo registrarIngresoVehiculo(Vehiculo vehiculo) {	
		if (!hayEspaciosDisponibles(vehiculo.getTipo())) {
			throw new ParquearException(LIMITE_DE_VEHICULOS);
		}
		return repositorioParqueo.guardarParqueo(new Parqueo(vehiculo, calendario.getFecha()));
	}

	public boolean hayEspaciosDisponibles(String tipoVehiculo) {
		return (tipoVehiculo.equalsIgnoreCase("carro") && repositorioParqueo.contadorParqueosPorTipo(tipoVehiculo)<LIMITE_CARROS) 
				|| (tipoVehiculo.equalsIgnoreCase("moto") && repositorioParqueo.contadorParqueosPorTipo(tipoVehiculo)<LIMITE_MOTOS);
	}
}
