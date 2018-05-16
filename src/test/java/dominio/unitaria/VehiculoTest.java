package dominio.unitaria;

import static org.junit.Assert.*;

import org.junit.Test;

import static databuilder.VehiculoBuilder.unVehiculo;
import dominio.Vehiculo;

public class VehiculoTest {

	private static final String PLACA = "ABC123";
	private static final String TIPO_CARRO = "CARRO";
	private static final String TIPO_MOTO = "MOTO";
	private static final int CILINDRAJE = 125;
	
	@Test
	public void crearCarroTest() {
		//Arrange y Act
		Vehiculo carro = unVehiculo()
				.conPlaca(PLACA)
				.conTipo(TIPO_CARRO)
				.conCilindraje(CILINDRAJE)
				.build();
		
		//Assert
		assertEquals(PLACA, carro.getPlaca());
		assertEquals(TIPO_CARRO, carro.getTipo());
		assertEquals(CILINDRAJE, carro.getCilindraje());
	}
	
	@Test
	public void crearMotoTest() {
		//Arrange y Act
		Vehiculo moto = unVehiculo()
				.conPlaca(PLACA)
				.conTipo(TIPO_MOTO)
				.conCilindraje(CILINDRAJE)
				.build();
		
		//Assert
		assertEquals(PLACA, moto.getPlaca());
		assertEquals(TIPO_MOTO, moto.getTipo());
		assertEquals(CILINDRAJE, moto.getCilindraje());
	}

}
