package databuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import parqueadero.dominio.modelo.Calendario;

public class CalendarioBuilder {

	private Calendar fecha;

	public CalendarioBuilder() {
		fecha = new GregorianCalendar(2018, Calendar.MAY, 22);
	}

	public CalendarioBuilder conFecha(Calendar fecha) {
		this.fecha = fecha;
		return this;
	}

	public Calendario build() {
		return new Calendario(fecha);
	}

	public static CalendarioBuilder unCalendario() {
		return new CalendarioBuilder();
	}
}
