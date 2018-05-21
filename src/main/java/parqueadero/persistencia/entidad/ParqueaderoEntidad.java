package parqueadero.persistencia.entidad;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Parqueadero")
public class ParqueaderoEntidad {

	@Id
	@GeneratedValue
	private Long id;
	@Embedded
	private VehiculoEntidad vehiculo;
	private Date fechaIngreso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public VehiculoEntidad getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(VehiculoEntidad vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}	
}
