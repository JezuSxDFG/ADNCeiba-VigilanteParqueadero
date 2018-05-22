package parqueadero.persistencia.builder;

import java.util.ArrayList;
import java.util.List;

import parqueadero.dominio.modelo.Parqueo;
import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.persistencia.entidad.ParqueaderoEntidad;

public class ParqueaderoBuilder {

	private ParqueaderoBuilder() {
	}

	public static ParqueaderoEntidad convertirAEntidad(Parqueo parqueo) {
		ParqueaderoEntidad parqueaderoEntidad = new ParqueaderoEntidad();
		parqueaderoEntidad.setVehiculo(VehiculoBuilder.convertirAEntidad(parqueo.getVehiculo()));
		parqueaderoEntidad.setFechaIngreso(parqueo.getFechaIngreso());
		return parqueaderoEntidad;
	}

	public static Parqueo convertirAParqueo(ParqueaderoEntidad parqueaderoEntidad) {
		Vehiculo vehiculo = new Vehiculo(parqueaderoEntidad.getVehiculo().getPlaca(),
				parqueaderoEntidad.getVehiculo().getTipo(), parqueaderoEntidad.getVehiculo().getCilindraje());
		return new Parqueo(vehiculo, parqueaderoEntidad.getFechaIngreso());
	}

	public static List<Parqueo> convertirAParqueadero(List<ParqueaderoEntidad> parqueaderoEntidad) {
		List<Parqueo> parqueadero = new ArrayList<>();
		for (ParqueaderoEntidad parqueoEntidad : parqueaderoEntidad) {
			parqueadero.add(convertirAParqueo(parqueoEntidad));
		}
		return parqueadero;
	}
}
