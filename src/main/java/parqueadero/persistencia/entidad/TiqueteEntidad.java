package parqueadero.persistencia.entidad;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Tiquete")
public class TiqueteEntidad {

	@Id
	@GeneratedValue
	private Long id;
	private String placa;
	private String tipo;
	private int cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private int cobro;

	public Long getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getCobro() {
		return cobro;
	}

	public void setCobro(int cobro) {
		this.cobro = cobro;
	}

}
