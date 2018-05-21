package parqueadero.dominio.modelo;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Calendario {

	private Calendar fecha = Calendar.getInstance();
	
	public Date getFecha() {
		return fecha.getTime();
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public boolean esDiaHabil() {
		return (fecha.get(Calendar.DAY_OF_WEEK) < 3);
	}
}
