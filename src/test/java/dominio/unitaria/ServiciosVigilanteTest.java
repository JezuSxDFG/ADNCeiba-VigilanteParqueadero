package dominio.unitaria;

import static org.junit.Assert.*;

import org.junit.Test;

import static databuilder.VehiculoBuilder.unVehiculo;
import dominio.ServiciosVigilante;
import dominio.Vehiculo;
import dominio.miscelanea.CalendarioParqueadero;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiciosVigilanteTest {

	
	@Test
	public void registrarIngresoTest() {
		//Arrange
		Vehiculo carro = unVehiculo().build();
		CalendarioParqueadero calendario = mock(CalendarioParqueadero.class);
		when(calendario.esDiaHabil()).thenReturn(true);
		ServiciosVigilante serviciosVigilante = new ServiciosVigilante(calendario);
		
		//Act
		boolean registroIngresado = serviciosVigilante.registrarIngreso(carro);
		
		//Assert
		assertTrue(registroIngresado);
	}

}
