package parqueadero.persistencia.repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import parqueadero.dominio.modelo.Parqueo;
import parqueadero.persistencia.builder.ParqueaderoBuilder;
import parqueadero.persistencia.repositorio.jpa.RepositorioParqueoJPA;

@Repository
public class RepositorioParqueoPersistente {

	@Autowired
	private RepositorioParqueoJPA repositorioParqueoJPA;

	public Parqueo guardarParqueo(Parqueo parqueo) {
		return ParqueaderoBuilder
				.convertirAParqueo(repositorioParqueoJPA.save(ParqueaderoBuilder.convertirAEntidad(parqueo)));
	}

	public int contadorParqueosPorTipo(String tipo) {
		return repositorioParqueoJPA.contarVehiculosPorTipo(tipo);
	}

	public Parqueo obtenerParqueoPorPlaca(String placa) {
		return ParqueaderoBuilder.convertirAParqueo(repositorioParqueoJPA.buscarVehiculoPorPlaca(placa));
	}

	public List<Parqueo> obtenerTodosParqueados() {
		return ParqueaderoBuilder.convertirAParqueadero(repositorioParqueoJPA.findAll());
	}

}
