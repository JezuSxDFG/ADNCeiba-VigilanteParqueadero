package parqueadero.persistencia.builder;

import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.persistencia.entidad.VehiculoEntidad;

public class VehiculoBuilder {
	
	private VehiculoBuilder() { }
	
	public static Vehiculo convertirADominio(VehiculoEntidad vehiculoEntidad) {
		Vehiculo vehiculo = null;
		if (vehiculoEntidad != null) {
			vehiculo = new Vehiculo(vehiculoEntidad.getPlaca(), vehiculoEntidad.getTipo(), vehiculoEntidad.getCilindraje());
		}
		return vehiculo;
	}
	
	public static VehiculoEntidad convertirAEntidad(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = new VehiculoEntidad();
		vehiculoEntidad.setPlaca(vehiculo.getPlaca());
		vehiculoEntidad.setTipo(vehiculo.getTipo());
		vehiculoEntidad.setCilindraje(vehiculo.getCilindraje());
		return vehiculoEntidad;
	}
}
