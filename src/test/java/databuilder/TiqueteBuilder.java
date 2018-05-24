package databuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import parqueadero.dominio.modelo.Tiquete;

public class TiqueteBuilder extends VehiculoBuilder{
	private Date fechaIngreso;
	private Date fechaSalida;
	private int cobro;
	
	public TiqueteBuilder() {
		super();
		fechaIngreso = new GregorianCalendar(2018, Calendar.MAY, 22).getTime();
		fechaIngreso = new GregorianCalendar(2018, Calendar.MAY, 23).getTime();
		cobro = 8000;
	}
	
	TiqueteBuilder conFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	TiqueteBuilder conFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	TiqueteBuilder conCobro(int cobro) {
		this.cobro = cobro;
		return this;
	}
	
	public Tiquete build() {
		return new Tiquete(super.build().getPlaca(), super.build().getTipo(), super.build().getCilindraje(), fechaIngreso, fechaSalida, cobro);
	}
	
	public static TiqueteBuilder unTiquete() {
		return new TiqueteBuilder();
	}
}
