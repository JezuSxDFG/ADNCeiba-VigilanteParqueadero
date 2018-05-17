package dominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import dominio.modelo.Vehiculo;

public interface RepositorioVehiculo extends JpaRepository<Vehiculo, Long> {
	
	Long countByTipo(String tipo);

}
