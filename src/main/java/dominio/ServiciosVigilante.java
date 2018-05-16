package dominio;

import java.util.Calendar;

import dominio.miscelanea.CalendarioParqueadero;
import dominio.repositorio.RepositorioVehiculo;

public class ServiciosVigilante {
	
	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_HORA_MOTO = 500;
	public static final int VALOR_DIA_CARRO = 8000;
	public static final int VALOR_DIA_MOTO = 4000;
	
	public static final String VEHICULO_NO_AUTORIZADO = "NO ESTA AUTORIZADO A INGRESAR";
	
	public ServiciosVigilante(CalendarioParqueadero calendario) {
		
	}
	
	public boolean registrarIngreso(Vehiculo vehiculo) {
		return true;
	}
}
