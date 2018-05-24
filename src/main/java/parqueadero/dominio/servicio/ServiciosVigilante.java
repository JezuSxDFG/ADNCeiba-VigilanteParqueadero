package parqueadero.dominio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import parqueadero.dominio.modelo.Calendario;
import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Tiquete;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.persistencia.repositorio.RepositorioParqueoPersistente;
import parqueadero.persistencia.repositorio.RepositorioTiquetePersistente;

@Service
public class ServiciosVigilante extends Vigilante {

	@Autowired
	public ServiciosVigilante(RepositorioParqueoPersistente repositorioParqueo,
			RepositorioTiquetePersistente repositorioTiquete, Calendario calendario) {
		super(repositorioParqueo, repositorioTiquete, calendario);
	}

	public Parqueo registrarIngresoVehiculo(Vehiculo vehiculo) {
		noEstaParqueado(vehiculo.getPlaca());
		placaNoTieneRestriccionDia(vehiculo.getPlaca());
		hayEspaciosDisponibles(vehiculo.getTipo());
		return generarIngresoVehiculo(vehiculo);
	}

	public List<Parqueo> obtenerRegistrosVehiculoIngresados() {
		return consultarVehiculosIngresados();
	}

	public Tiquete obtenerTiquete(String placa) {
		return generarTiquete(placa);
	}

	public Tiquete registrarSalidaVehiculo(String placa) {
		return guardarTiquete(placa);
	}
}
