package databuilder;

import dominio.modelo.Vehiculo;

public class VehiculoBuilder {

	private String placa;
	private String tipo;
	private int cilindraje;
	
	public VehiculoBuilder() {
		placa = "ABC123";
		tipo = "CARRO";
		cilindraje = 0;
	}
	
	public VehiculoBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoBuilder conTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public VehiculoBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(placa, tipo, cilindraje);
	}
	
	public static VehiculoBuilder unVehiculo() {
		return new VehiculoBuilder();
	}
}
