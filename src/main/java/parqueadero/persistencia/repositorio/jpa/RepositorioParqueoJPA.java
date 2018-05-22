package parqueadero.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import parqueadero.persistencia.entidad.ParqueaderoEntidad;

@Repository
public interface RepositorioParqueoJPA extends JpaRepository<ParqueaderoEntidad, Long> {

	@Query("SELECT P FROM Parqueadero P WHERE P.vehiculo.placa=:placa")
	ParqueaderoEntidad buscarVehiculoPorPlaca(@Param("placa") String placa);

	@Query("SELECT count(P) FROM Parqueadero P WHERE P.vehiculo.tipo=:tipo")
	int contarVehiculosPorTipo(@Param("tipo") String tipo);
}
