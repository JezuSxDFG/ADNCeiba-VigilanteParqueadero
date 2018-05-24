package parqueadero.persistencia.repositorio.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parqueadero.persistencia.entidad.TiqueteEntidad;

@Repository
public interface RepositorioTiqueteJPA extends JpaRepository<TiqueteEntidad, Long>{

}
