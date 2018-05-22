package dominio.unitaria;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import parqueadero.VigilanteParqueaderoApplication;
import parqueadero.dominio.modelo.Vehiculo;

import static databuilder.VehiculoBuilder.unVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VigilanteParqueaderoApplication.class)
@DataJpaTest
public class VehiculoTest {

	private static final String PLACA = "ABC123";
	private static final String TIPO_CARRO = "CARRO";
	private static final String TIPO_MOTO = "MOTO";
	private static final int CILINDRAJE = 125;

	@Test
	public void crearVehiculoConPlacaTest() {
		// Arrange y Act
		Vehiculo carro = new Vehiculo();
		carro = unVehiculo().conPlaca(PLACA).build();

		// Assert
		assertEquals(PLACA, carro.getPlaca());
	}

	@Test
	public void crearVehiculoTipoCarroTest() {
		// Arrange y Act
		Vehiculo carro = unVehiculo().conTipo(TIPO_CARRO).build();

		// Assert
		assertEquals(TIPO_CARRO, carro.getTipo());
	}

	@Test
	public void crearVehiculoTipoMotoTest() {
		// Arrange y Act
		Vehiculo carro = unVehiculo().conTipo(TIPO_MOTO).build();

		// Assert
		assertEquals(TIPO_MOTO, carro.getTipo());
	}

	@Test
	public void crearVehiculoConCilindrajeTest() {
		// Arrange y Act
		Vehiculo carro = unVehiculo().conCilindraje(CILINDRAJE).build();

		// Assert
		assertEquals(CILINDRAJE, carro.getCilindraje());
	}

}
