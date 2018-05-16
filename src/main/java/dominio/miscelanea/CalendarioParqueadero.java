package dominio.miscelanea;

import java.util.Calendar;

public class CalendarioParqueadero {

	private Calendar calendario = Calendar.getInstance();
	
	public boolean esDiaHabil() {
		return (!(calendario.get(Calendar.DAY_OF_WEEK) > 2));
	}
}
