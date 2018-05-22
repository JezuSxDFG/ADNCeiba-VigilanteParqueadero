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

}
