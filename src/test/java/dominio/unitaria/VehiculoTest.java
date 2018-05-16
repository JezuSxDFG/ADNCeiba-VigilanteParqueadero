package dominio.unitaria;

import static org.junit.Assert.*;

import org.junit.Test;

import databuilder.VehiculoBuilder;
import dominio.Vehiculo;

public class VehiculoTest {

	private static final String PLACA = "ABC123";
	private static final String TIPO_CARRO = "CARRO";
	private static final String TIPO_MOTO = "MOTO";
	private static final int CILINDRAJE = 125;
	
	@Test
	public void crearCarroTest() {
		//Arrange
		VehiculoBuilder CarroBuilder = new VehiculoBuilder().
				conPlaca(PLACA).
				conTipo(TIPO_CARRO).
				conCilindraje(CILINDRAJE);
				
		//Act
		Vehiculo carro = CarroBuilder.build();
		
		//Assert
		assertEquals(PLACA, carro.getPlaca());
		assertEquals(TIPO_CARRO, carro.getTipo());
		assertEquals(CILINDRAJE, carro.getCilindraje());
	}
	
	@Test
	public void crearMotoTest() {
		//Arrange
		VehiculoBuilder MotoBuilder = new VehiculoBuilder().
				conPlaca(PLACA).
				conTipo(TIPO_MOTO).
				conCilindraje(CILINDRAJE);
				
		//Act
		Vehiculo moto = MotoBuilder.build();
		
		//Assert
		assertEquals(PLACA, moto.getPlaca());
		assertEquals(TIPO_MOTO, moto.getTipo());
		assertEquals(CILINDRAJE, moto.getCilindraje());
	}

}
