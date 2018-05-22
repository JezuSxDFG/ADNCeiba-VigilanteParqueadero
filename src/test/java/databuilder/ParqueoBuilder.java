package databuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Vehiculo;
import static databuilder.VehiculoBuilder.unVehiculo;

public class ParqueoBuilder {

	private Vehiculo vehiculo;
	private Date fechaIngreso;

	public ParqueoBuilder() {
		vehiculo = unVehiculo().build();
		fechaIngreso = new GregorianCalendar(2018, Calendar.MAY, 22).getTime();
	}

	public ParqueoBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}

	public ParqueoBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}

	public Parqueo build() {
		return new Parqueo(vehiculo, fechaIngreso);
	}

	public static ParqueoBuilder unParqueo() {
		return new ParqueoBuilder();
	}

}
