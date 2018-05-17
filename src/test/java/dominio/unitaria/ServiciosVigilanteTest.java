package dominio.unitaria;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static databuilder.VehiculoBuilder.unVehiculo;

import dominio.modelo.Vehiculo;
import dominio.repositorio.RepositorioVehiculo;
import dominio.servicio.ServiciosVigilante;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiciosVigilanteTest {
		
	@Mock
	RepositorioVehiculo repositorioVehiculo;
	
	@Test
	public void registrarIngresoVehiculoTest() {
		//Arrange
		Vehiculo vehiculo = unVehiculo().conPlaca("ABC123").build();
		ServiciosVigilante serviciosVigilante = new ServiciosVigilante(repositorioVehiculo);
		when(serviciosVigilante.contadorVehiculosPorTipo(vehiculo.getTipo())).thenReturn(1L);
		when(repositorioVehiculo.save(vehiculo)).thenReturn(vehiculo);
		//Act
		Vehiculo carroIngresado = serviciosVigilante.registrarIngresoVehiculo(vehiculo);
		
		//Assert
		assertEquals(vehiculo.getPlaca(),carroIngresado.getPlaca());
	}

}
