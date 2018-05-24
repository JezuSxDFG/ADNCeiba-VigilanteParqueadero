package dominio.unitaria;

import static databuilder.CalendarioBuilder.unCalendario;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import parqueadero.dominio.modelo.Calendario;

public class CalendarioTest {

	private static final Calendar FECHA_HABIL = new GregorianCalendar(2018, Calendar.MAY, 21);
	private static final Calendar FECHA_NO_HABIL = new GregorianCalendar(2018, Calendar.MAY, 22);
	private static final Calendar FECHA_INGRESO = new GregorianCalendar(2018, 5, 22, 3, 50);
	private static final Calendar FECHA_SALIDA = new GregorianCalendar(2018, 5, 23, 3, 51);

	@Test
	public void esDiaHabilTest() {
		// Arrange y Act
		Calendario calendario = unCalendario().conFecha(FECHA_HABIL).build();
		// Act
		boolean esDiaHabil = calendario.esDiaHabil();
		// Assert
		assertTrue(esDiaHabil);
		assertEquals(FECHA_HABIL, calendario.getFecha());
	}

	@Test
	public void noEsDiaHabilTest() {
		// Arrange y Act
		Calendario calendario = unCalendario().conFecha(FECHA_NO_HABIL).build();
		// Act
		boolean esDiaHabil = calendario.esDiaHabil();
		// Assert
		assertFalse(esDiaHabil);
	}

	@Test
	public void diferenciaEnHorasTest() {
		// Arrange y Act
		Calendario calendario = unCalendario().build();
		// Act
		long esDiaHabil = calendario.diferenciaEnHoras(FECHA_INGRESO.getTime(), FECHA_SALIDA.getTime());
		System.out.println(esDiaHabil);
		// Assert
		assertEquals(25, esDiaHabil);
	}

}
