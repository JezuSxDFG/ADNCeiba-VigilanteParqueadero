package dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dominio.excepcion.ParquearException;
import dominio.modelo.Vehiculo;
import dominio.repositorio.RepositorioVehiculo;

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
	
	@Autowired
	private RepositorioVehiculo repositorioVehiculo;
	
	public ServiciosVigilante(RepositorioVehiculo repositorioVehiculo){
		this.repositorioVehiculo= repositorioVehiculo;
	}
	
	public List<Vehiculo> mostrarTodosVehiculos(){
		return repositorioVehiculo.findAll();
	}
	
	public Vehiculo registrarIngresoVehiculo(Vehiculo vehiculo) {	
		if (!hayEspaciosDisponibles(vehiculo.getTipo())) {
			throw new ParquearException(LIMITE_DE_VEHICULOS);
		}
		return repositorioVehiculo.save(vehiculo);
	}
	
	public boolean hayEspaciosDisponibles(String tipoVehiculo) {
		return (tipoVehiculo.equalsIgnoreCase("carro") && contadorVehiculosPorTipo(tipoVehiculo)<LIMITE_CARROS) 
				|| (tipoVehiculo.equalsIgnoreCase("moto") && contadorVehiculosPorTipo(tipoVehiculo)<LIMITE_MOTOS);
	}
	
	public Long contadorVehiculosPorTipo(String tipoVehiculo) {
		return repositorioVehiculo.countByTipo(tipoVehiculo);
	}
}
