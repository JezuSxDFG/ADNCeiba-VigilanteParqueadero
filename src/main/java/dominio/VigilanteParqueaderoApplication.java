package dominio;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dominio.modelo.Vehiculo;
import dominio.repositorio.RepositorioVehiculo;

@SpringBootApplication
public class VigilanteParqueaderoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VigilanteParqueaderoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner configInicial(RepositorioVehiculo repositorioVehiculo) {
		return args -> {
			repositorioVehiculo.save(new Vehiculo("AAA111","CARRO"));
			repositorioVehiculo.save(new Vehiculo("BBB22","MOTO", 125));
			repositorioVehiculo.save(new Vehiculo("CCC333","CARRO", 780));
			repositorioVehiculo.save(new Vehiculo("DDD444","MOTO", 225));
		};
	}
	
}
