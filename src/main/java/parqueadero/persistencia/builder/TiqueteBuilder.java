package parqueadero.persistencia.builder;

import parqueadero.dominio.modelo.Tiquete;
import parqueadero.persistencia.entidad.TiqueteEntidad;

public class TiqueteBuilder {

	private TiqueteBuilder() {
	}

	public static Tiquete convertirADominio(TiqueteEntidad tiqueteEntidad) {
		return new Tiquete(tiqueteEntidad.getPlacaT(), tiqueteEntidad.getTipoT(), tiqueteEntidad.getCilindrajeT(),
				tiqueteEntidad.getFechaIngreso(), tiqueteEntidad.getFechaSalida(), tiqueteEntidad.getCobro());
	}
	
	public static TiqueteEntidad convertirAEntidad(Tiquete tiquete) {
		TiqueteEntidad tiqueteEntidad = new TiqueteEntidad();
		tiqueteEntidad.setPlacaT(tiquete.getPlaca());
		tiqueteEntidad.setTipoT(tiquete.getTipo());
		tiqueteEntidad.setCilindrajeT(tiquete.getCilindraje());
		tiqueteEntidad.setFechaIngreso(tiquete.getFechaIngreso());
		tiqueteEntidad.setFechaSalida(tiquete.getFechaSalida());
		tiqueteEntidad.setCobro(tiquete.getCobro());
		return tiqueteEntidad;
	}
}
