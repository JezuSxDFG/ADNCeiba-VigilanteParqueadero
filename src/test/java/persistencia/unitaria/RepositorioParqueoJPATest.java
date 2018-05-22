package persistencia.unitaria;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import parqueadero.VigilanteParqueaderoApplication;
import parqueadero.persistencia.entidad.ParqueaderoEntidad;
import parqueadero.persistencia.entidad.VehiculoEntidad;
import parqueadero.persistencia.repositorio.jpa.RepositorioParqueoJPA;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VigilanteParqueaderoApplication.class)
@DataJpaTest
public class RepositorioParqueoJPATest {

	@Autowired
	private TestEntityManager entityMangar;

	@Autowired
	private RepositorioParqueoJPA repositorioParqueo;

	@Test
	public void buscarVehiculoPorPlacaTest() {
		// Arrange
		VehiculoEntidad vehiculo = new VehiculoEntidad();
		vehiculo.setPlaca("xyz123");
		vehiculo.setCilindraje(0);
		ParqueaderoEntidad parqueo = new ParqueaderoEntidad();
		parqueo.setVehiculo(vehiculo);
		entityMangar.persist(parqueo);
		entityMangar.flush();

		// Act
		ParqueaderoEntidad parqueoPersistido = repositorioParqueo
				.buscarVehiculoPorPlaca(parqueo.getVehiculo().getPlaca());
		// Assert
		assertEquals(parqueo.getId(), parqueoPersistido.getId());
	}

	@Test
	public void contarVehiculosPorTipoTest() {
		// Arrange
		VehiculoEntidad vehiculo = new VehiculoEntidad();
		vehiculo.setTipo("carro");

		ParqueaderoEntidad parqueo1 = new ParqueaderoEntidad();
		parqueo1.setVehiculo(vehiculo);
		entityMangar.persist(parqueo1);

		ParqueaderoEntidad parqueo2 = new ParqueaderoEntidad();
		parqueo2.setVehiculo(vehiculo);
		entityMangar.persist(parqueo2);
		entityMangar.flush();

		// Act
		int numeroVehiculoPorTipo = repositorioParqueo.contarVehiculosPorTipo(parqueo1.getVehiculo().getTipo());
		// Assert
		assertEquals(2, numeroVehiculoPorTipo);
	}

}
