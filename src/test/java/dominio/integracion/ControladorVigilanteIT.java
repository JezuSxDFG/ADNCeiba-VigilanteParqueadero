package dominio.integracion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import parqueadero.VigilanteParqueaderoApplication;
import parqueadero.dominio.controlador.ControladorVigilante;
import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.dominio.servicio.ServiciosVigilante;

import static databuilder.VehiculoBuilder.unVehiculo;
import static databuilder.ParqueoBuilder.unParqueo;
import static org.mockito.Mockito.when;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = {VigilanteParqueaderoApplication.class},webEnvironment=WebEnvironment.RANDOM_PORT)
public class ControladorVigilanteIT {

	//@Autowired
	//private WebApplicationContext webApplicationContext;
	
	@Test
	public void noImplementado() {
		
	}
	
	

}
