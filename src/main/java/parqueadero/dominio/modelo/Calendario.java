package parqueadero.dominio.modelo;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class Calendario {

	private Calendar fecha = Calendar.getInstance();

	private static final int NO_HABILITADO_MARTES = 3;

	public Calendario() {
	}

	public Calendario(Calendar fecha) {
		this.fecha = fecha;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public boolean esDiaHabil() {
		return (fecha.get(Calendar.DAY_OF_WEEK) < NO_HABILITADO_MARTES);
	}
}
