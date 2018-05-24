package parqueadero.dominio.modelo;

import java.util.Calendar;
import java.util.Date;

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

	public Date obtenerFechaActual() {
		fecha.setTime(new Date());
		return fecha.getTime();
	}

	public boolean esDiaHabil() {
		return (fecha.get(Calendar.DAY_OF_WEEK) < NO_HABILITADO_MARTES);
	}
	
	public int diferenciaEnHoras(Date fechaIngreso, Date fechaSalida) {
		Calendar cFechaIngreso = Calendar.getInstance();
		cFechaIngreso.setTime(fechaIngreso);
		Calendar cFechaSalida = Calendar.getInstance();
		cFechaSalida.setTime(fechaSalida);
		int minutos = (int) ((cFechaSalida.getTimeInMillis()-cFechaIngreso.getTimeInMillis())/1000/60);
		return minutos/60 + ((minutos%60==0)? 0:1);
	}
}
