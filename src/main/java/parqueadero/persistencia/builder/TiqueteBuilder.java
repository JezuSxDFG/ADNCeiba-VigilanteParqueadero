package parqueadero.persistencia.builder;

import parqueadero.dominio.modelo.Tiquete;
import parqueadero.persistencia.entidad.TiqueteEntidad;

public class TiqueteBuilder {

	private TiqueteBuilder() {
	}

	public static Tiquete convertirADominio(TiqueteEntidad tiqueteEntidad) {
		return new Tiquete(tiqueteEntidad.getPlaca(), tiqueteEntidad.getTipo(), tiqueteEntidad.getCilindraje(),
				tiqueteEntidad.getFechaIngreso(), tiqueteEntidad.getFechaSalida(), tiqueteEntidad.getCobro());
	}
	
	public static TiqueteEntidad convertirAEntidad(Tiquete tiquete) {
		TiqueteEntidad tiqueteEntidad = new TiqueteEntidad();
		tiqueteEntidad.setPlaca(tiquete.getPlaca());
		tiqueteEntidad.setTipo(tiquete.getTipo());
		tiqueteEntidad.setCilindraje(tiquete.getCilindraje());
		tiqueteEntidad.setFechaIngreso(tiquete.getFechaIngreso());
		tiqueteEntidad.setFechaSalida(tiquete.getFechaSalida());
		tiqueteEntidad.setCobro(tiquete.getCobro());
		return tiqueteEntidad;
	}
}
