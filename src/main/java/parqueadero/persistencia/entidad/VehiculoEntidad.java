package parqueadero.persistencia.entidad;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class VehiculoEntidad {

	@NotEmpty(message = "La placa es necesaria")
	private String placa;
	private String tipo;
	private int cilindraje;
	
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
	
	

}
