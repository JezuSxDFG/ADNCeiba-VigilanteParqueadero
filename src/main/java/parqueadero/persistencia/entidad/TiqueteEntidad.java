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
	private String placaT;
	private String tipoT;
	private int cilindrajeT;
	private Date fechaIngreso;
	private Date fechaSalida;
	private int cobro;

	public Long getId() {
		return id;
	}

	public String getPlacaT() {
		return placaT;
	}

	public void setPlacaT(String placaT) {
		this.placaT = placaT;
	}

	public String getTipoT() {
		return tipoT;
	}

	public void setTipoT(String tipoT) {
		this.tipoT = tipoT;
	}

	public int getCilindrajeT() {
		return cilindrajeT;
	}

	public void setCilindrajeT(int cilindrajeT) {
		this.cilindrajeT = cilindrajeT;
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
