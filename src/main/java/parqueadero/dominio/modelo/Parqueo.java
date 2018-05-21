package parqueadero.dominio.modelo;

import java.util.Date;

public class Parqueo {

	private Vehiculo vehiculo;
	private Date fechaIngreso;
	
	public Parqueo(Vehiculo vehiculo, Date fechaIngreso) {
		this.vehiculo = vehiculo;
		this.fechaIngreso = fechaIngreso;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
}
