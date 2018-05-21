package parqueadero.dominio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.dominio.servicio.ServiciosVigilante;

@RestController
@RequestMapping("/vigilante")
@CrossOrigin
public class ControladorVigilante {

	@Autowired
	private ServiciosVigilante servicioVigilante;
    
    @RequestMapping(value = "/vehiculo", method = RequestMethod.POST)
   	public ResponseEntity<Parqueo> guardarRegistroIngresoVehiculo(@RequestBody Vehiculo vehiculo) {
		return new ResponseEntity<>(servicioVigilante.registrarIngresoVehiculo(vehiculo), HttpStatus.OK);
   	}
	
}
