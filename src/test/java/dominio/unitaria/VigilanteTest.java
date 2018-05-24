package dominio.unitaria;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import parqueadero.VigilanteParqueaderoApplication;
import parqueadero.dominio.excepcion.ParquearException;
import parqueadero.dominio.modelo.Calendario;
import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Tiquete;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.dominio.servicio.Vigilante;
import parqueadero.persistencia.repositorio.RepositorioParqueoPersistente;
import parqueadero.persistencia.repositorio.RepositorioTiquetePersistente;

import static databuilder.VehiculoBuilder.unVehiculo;
import static databuilder.ParqueoBuilder.unParqueo;
import static databuilder.TiqueteBuilder.unTiquete;
import static databuilder.CalendarioBuilder.unCalendario;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VigilanteParqueaderoApplication.class)
@DataJpaTest
public class VigilanteTest {

	@InjectMocks
	private Vigilante serviciosVigilante;
	@Mock
	private RepositorioParqueoPersistente repositorioParqueo;
	@Mock
	private RepositorioTiquetePersistente repositorioTiquete;
	@Mock
	private Calendario calendario;

	public static final String VEHICULO_YA_PARQUEADO = "LA PLACA DEL VEHICULO YA SE ENCUENTRA DENTRO";
	public static final String VEHICULO_NO_AUTORIZADO = "NO ESTA AUTORIZADO A INGRESAR HOY";
	public static final String LIMITE_DE_CARROS = "EL CUPO DE CARROS SE ENCUENTRA LLENO";
	public static final String LIMITE_DE_MOTOS = "EL CUPO DE MOTOS SE ENCUENTRA LLENO";

	@Test
	public void generarIngresoVehiculoTest() {
		// Arrange
		Vehiculo vehiculo = unVehiculo().build();
		Date fechaIngreso = unCalendario().build().getFecha().getTime();
		Parqueo parqueo = unParqueo().build();
		when(calendario.obtenerFechaActual()).thenReturn(fechaIngreso);
		when(repositorioParqueo.guardarParqueo(parqueo)).thenReturn(parqueo);
		// Act
		Parqueo parqueoIngresado = serviciosVigilante.generarIngresoVehiculo(vehiculo);

		// Assert
		assertNull(parqueoIngresado);
	}

	@Test
	public void noHayEspaciosDisponiblesCarrosTest() {
		when(repositorioParqueo.contadorParqueosPorTipo("carro")).thenReturn(20);
		try {
			serviciosVigilante.hayEspaciosDisponibles("carro");
			fail();
		} catch (ParquearException e) {
			assertEquals(LIMITE_DE_CARROS, e.getMessage());
		}
	}

	@Test
	public void noHayEspaciosDisponiblesMotosTest() {
		when(repositorioParqueo.contadorParqueosPorTipo("moto")).thenReturn(10);
		try {
			serviciosVigilante.hayEspaciosDisponibles("moto");
			fail();
		} catch (ParquearException e) {
			assertEquals(LIMITE_DE_MOTOS, e.getMessage());
		}
	}

	@Test
	public void estaParqueadoTest() {
		Parqueo parqueo = unParqueo().build();
		when(repositorioParqueo.obtenerParqueoPorPlaca("ABC123")).thenReturn(parqueo);
		try {
			serviciosVigilante.noEstaParqueado("ABC123");
			fail();
		} catch (ParquearException e) {
			assertEquals(VEHICULO_YA_PARQUEADO, e.getMessage());
		}
	}

	@Test
	public void tieneRestriccionPlacaDiaTest() {
		when(calendario.esDiaHabil()).thenReturn(false);
		try {
			serviciosVigilante.placaNoTieneRestriccionDia("ABC123");
			fail();
		} catch (ParquearException e) {
			assertEquals(VEHICULO_NO_AUTORIZADO, e.getMessage());
		}
	}

	@Test
	public void generarTiqueteTest() {
		// Arrange
		Date fechaIngreso = unCalendario().build().getFecha().getTime();
		Parqueo parqueo = unParqueo().build();
		when(repositorioParqueo.obtenerParqueoPorPlaca(parqueo.getVehiculo().getPlaca())).thenReturn(parqueo);
		when(calendario.obtenerFechaActual()).thenReturn(fechaIngreso);

		// Act
		Tiquete tiquete = serviciosVigilante.generarTiquete(parqueo.getVehiculo().getPlaca());

		assertNotNull(tiquete);
	}

	@Test
	public void calcularCostoParqueoCarroTest() {
		// Arrange
		Parqueo parqueo = unParqueo().build();
		Tiquete tiquete = unTiquete().build();
		final int NUMERO_HORAS = 27;
		final int COSTO_PARQUEO = 11000;
		when(calendario.diferenciaEnHoras(parqueo.getFechaIngreso(), tiquete.getFechaSalida()))
				.thenReturn(NUMERO_HORAS);

		// Act
		int costoParqueo = serviciosVigilante.calcularCostoParqueo(parqueo, tiquete.getFechaSalida());

		assertEquals(COSTO_PARQUEO, costoParqueo);
	}

	@Test
	public void calcularCostoParqueoMotoAltoCCTest() {
		// Arrange
		Vehiculo moto = unVehiculo().conTipo("moto").conCilindraje(650).build();
		Parqueo parqueo = unParqueo().conVehiculo(moto).build();
		Tiquete tiquete = unTiquete().build();
		final int NUMERO_HORAS = 10;
		final int COSTO_PARQUEO = 6000;
		when(calendario.diferenciaEnHoras(parqueo.getFechaIngreso(), tiquete.getFechaSalida()))
				.thenReturn(NUMERO_HORAS);

		// Act
		int costoParqueo = serviciosVigilante.calcularCostoParqueo(parqueo, tiquete.getFechaSalida());

		assertEquals(COSTO_PARQUEO, costoParqueo);
	}

}
