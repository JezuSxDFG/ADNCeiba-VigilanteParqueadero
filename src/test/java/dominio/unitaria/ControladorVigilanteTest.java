package dominio.unitaria;


import static databuilder.TiqueteBuilder.unTiquete;
import static databuilder.ParqueoBuilder.unParqueo;
import static databuilder.VehiculoBuilder.unVehiculo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import parqueadero.dominio.controlador.ControladorVigilante;
import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Tiquete;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.dominio.servicio.ServiciosVigilante;

@RunWith(SpringRunner.class)
public class ControladorVigilanteTest {
	
	private final static String PLACA = "ABC123";
	
	@InjectMocks
	private ControladorVigilante controladorVigilante;
	
	@Mock
	private ServiciosVigilante serviciosVigilante;
	
	@Test
	public void guardarRegistrarIngresoVehiculoTest() {
		final Vehiculo vehiculo = unVehiculo().build();
		final Parqueo parqueo = unParqueo().build();
		when(serviciosVigilante.registrarIngresoVehiculo(vehiculo)).thenReturn(parqueo);
		
		final ResponseEntity<Parqueo> parqueoRespuesta = controladorVigilante.guardarRegistroIngresoVehiculo(vehiculo); 
		
		assertNotNull(parqueoRespuesta);
		assertEquals(PLACA, parqueoRespuesta.getBody().getVehiculo().getPlaca());
	}
	
	@Test
	public void obtenerRegistrosVehiculosIngresadosTest(){
		final Parqueo parqueo = unParqueo().build();
		final List<Parqueo> listaParqueos = new ArrayList<>();
		listaParqueos.add(parqueo);
		when(serviciosVigilante.obtenerRegistrosVehiculoIngresados()).thenReturn(listaParqueos);
		
		final ResponseEntity<List<Parqueo>> parqueoRespuesta = controladorVigilante.obtenerRegistrosVehiculosIngresados(); 
		
		assertNotNull(parqueoRespuesta);
		assertEquals(PLACA, parqueoRespuesta.getBody().get(0).getVehiculo().getPlaca());
	}
	
	@Test
	public void obtenerTiqueteTest(){
		final Tiquete tiquete = unTiquete().build();
		when(serviciosVigilante.obtenerTiquete(PLACA)).thenReturn(tiquete);
		
		final ResponseEntity<Tiquete> parqueoRespuesta = controladorVigilante.obtenerTiquete(PLACA); 
		
		assertNotNull(parqueoRespuesta);
		assertEquals(PLACA, parqueoRespuesta.getBody().getPlaca());
	}
	
	@Test
	public void registrarSalidaVehiculoTest(){
		final Tiquete tiquete = unTiquete().build();
		when(serviciosVigilante.registrarSalidaVehiculo(PLACA)).thenReturn(tiquete);
		
		final ResponseEntity<Tiquete> parqueoRespuesta = controladorVigilante.registrarSalidaVehiculo(PLACA); 
		
		assertNotNull(parqueoRespuesta);
		assertEquals(PLACA, parqueoRespuesta.getBody().getPlaca());
	}

}
