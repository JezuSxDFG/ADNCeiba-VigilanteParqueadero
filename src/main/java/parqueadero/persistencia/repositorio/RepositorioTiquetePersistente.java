package parqueadero.persistencia.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import parqueadero.dominio.modelo.Tiquete;
import parqueadero.persistencia.builder.TiqueteBuilder;
import parqueadero.persistencia.repositorio.jpa.RepositorioTiqueteJPA;

@Repository
public class RepositorioTiquetePersistente {

	@Autowired
	RepositorioTiqueteJPA repositorioTiqueteJPA;
	
	public Tiquete guardarTiquete(Tiquete tiquete) {
		return TiqueteBuilder.convertirADominio(repositorioTiqueteJPA.save(TiqueteBuilder.convertirAEntidad(tiquete)));
	}
}
