package parqueadero.dominio.modelo;

import java.util.Date;

public class Tiquete extends Vehiculo{

	private Date fechaIngreso;
	private Date fechaSalida;
	private int cobro;

	public Tiquete(String placa, String tipo, int cilindraje, Date fechaIngreso, Date fechaSalida,
			int cobro) {
		super(placa, tipo, cilindraje);
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.cobro = cobro;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public int getCobro() {
		return cobro;
	}

}
