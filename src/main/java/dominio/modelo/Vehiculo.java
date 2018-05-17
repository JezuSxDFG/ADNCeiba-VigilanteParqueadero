package dominio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Vehiculo {
	
	@Id
	@GeneratedValue
	private long id;
	@Size(min=5, max=6)
	private String placa;
	private String tipo;
	private int cilindraje;
	
	public Vehiculo() {
	}
	
	public Vehiculo(String placa, String tipo) {
		this.placa = placa;
		this.tipo = tipo;
	}

	public Vehiculo(String placa, String tipo, int cilindraje) {
		this.placa = placa;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
	}
	
	public long getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCilindraje() {
		return cilindraje;
	}
	
	
	
	

}
