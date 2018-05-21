package parqueadero;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import parqueadero.dominio.modelo.Vehiculo;

@SpringBootApplication
@ComponentScan("parqueadero")
@EnableAutoConfiguration
public class VigilanteParqueaderoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VigilanteParqueaderoApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner configInicial(RepositorioVehiculo repositorioVehiculo) {
		return args -> {
			repositorioVehiculo.guardar(new Vehiculo("AAA111","CARRO"));
			repositorioVehiculo.guardar(new Vehiculo("BBB22","MOTO", 125));
			repositorioVehiculo.guardar(new Vehiculo("CCC333","CARRO", 780));
			repositorioVehiculo.guardar(new Vehiculo("DDD444","MOTO", 225));
		};
	}
	*/
}
