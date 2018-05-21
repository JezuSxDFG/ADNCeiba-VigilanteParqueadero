package dominio.unitaria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import parqueadero.VigilanteParqueaderoApplication;
import parqueadero.dominio.excepcion.ParquearException;
import parqueadero.dominio.modelo.Calendario;
import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.dominio.servicio.ServiciosVigilante;
import parqueadero.persistencia.repositorio.RepositorioParqueoPersistente;

import static databuilder.VehiculoBuilder.unVehiculo;
import static databuilder.ParqueoBuilder.unParqueo;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VigilanteParqueaderoApplication.class)
@DataJpaTest
public class ServiciosVigilanteTest {
	
	@InjectMocks
	private ServiciosVigilante serviciosVigilante;
	@Mock
	private RepositorioParqueoPersistente repositorioParqueo;
	@Mock
	private Calendario calendario;
	
	public static final String LIMITE_DE_VEHICULOS = "EL PARQUEADERO SE ENCUENTRA LLENO";
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void registrarIngresoVehiculoTest() {
		//Arrange
		Vehiculo vehiculo = unVehiculo().conPlaca("ABC123").build();
		Parqueo parqueo = unParqueo().build();
		System.out.println("---/// Creo el vehiculo/// ---");
		ServiciosVigilante serviciosVigilante = new ServiciosVigilante(repositorioParqueo, calendario);
		System.out.println("---/// Entro a Servicio Vigilante/// ---");
		when(serviciosVigilante.hayEspaciosDisponibles(vehiculo.getTipo())).thenReturn(true);
		when(repositorioParqueo.guardarParqueo(parqueo)).thenReturn(parqueo);
		//Act
		Parqueo carroIngresado = serviciosVigilante.registrarIngresoVehiculo(vehiculo);
		
		//Assert
		assertEquals(parqueo.getFechaIngreso(),carroIngresado.getFechaIngreso());
	}
	
	@Test
	public void noHayEspaciosDisponiblesCarros() {
		when(repositorioParqueo.contadorParqueosPorTipo("carro")).thenReturn(20);
		try {
			serviciosVigilante.hayEspaciosDisponibles("carro");
			fail();
		} catch (ParquearException e) {
			assertEquals(LIMITE_DE_VEHICULOS, e.getMessage());
		}
	}

}
