package dominio.unitaria;

import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Vehiculo;
import static databuilder.VehiculoBuilder.unVehiculo;
import static databuilder.ParqueoBuilder.unParqueo;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class ParqueoTest {

	private static final Vehiculo VEHICULO = unVehiculo().build();
	private static final Date FECHA_INGRESO = new GregorianCalendar(2018, Calendar.MAY, 22).getTime();

	@Test
	public void crearParqueoConVehiculoTest() {
		// Arrange y Act
		Parqueo parqueo = unParqueo().conVehiculo(VEHICULO).build();

		// Assert
		assertEquals(VEHICULO, parqueo.getVehiculo());
	}

	@Test
	public void crearParqueoConFechaIngresoTest() {
		// Arrange y Act
		Parqueo parqueo = unParqueo().conFechaIngreso(FECHA_INGRESO).build();

		// Assert
		assertEquals(FECHA_INGRESO, parqueo.getFechaIngreso());
	}

}
