package parqueadero.dominio.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Tiquete;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.dominio.servicio.ServiciosVigilante;

@RestController
@RequestMapping("/parqueadero")
@CrossOrigin
public class ControladorVigilante {

	@Autowired
	private ServiciosVigilante servicioVigilante;

	@PostMapping("/vehiculo")
	public ResponseEntity<Parqueo> guardarRegistroIngresoVehiculo(@RequestBody Vehiculo vehiculo) {
		return new ResponseEntity<>(servicioVigilante.registrarIngresoVehiculo(vehiculo), HttpStatus.OK);
	}

	@GetMapping("/vehiculo")
	public ResponseEntity<List<Parqueo>> obtenerRegistrosVehiculosIngresados() {
		return new ResponseEntity<>(servicioVigilante.obtenerRegistrosVehiculoIngresados(), HttpStatus.OK);
	}

	@GetMapping("/tiquete/{placa}")
	public ResponseEntity<Tiquete> obtenerTiquete(@PathVariable("placa") String placa) {
		return new ResponseEntity<>(servicioVigilante.obtenerTiquete(placa), HttpStatus.OK);
	}

	@DeleteMapping("/vehiculo/{placa}")
	public ResponseEntity<Tiquete> registrarSalidaVehiculo(@PathVariable("placa") String placa) {
		return new ResponseEntity<>(servicioVigilante.registrarSalidaVehiculo(placa), HttpStatus.OK);
	}
}
