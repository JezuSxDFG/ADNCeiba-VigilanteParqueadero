package parqueadero;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import parqueadero.dominio.modelo.Vehiculo;
import parqueadero.dominio.servicio.ServiciosVigilante;

@SpringBootApplication
@ComponentScan("parqueadero")
@EnableAutoConfiguration
public class VigilanteParqueaderoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VigilanteParqueaderoApplication.class, args);
	}

	@Bean
	public CommandLineRunner configInicial(ServiciosVigilante serviciosVigilante) {
		return args -> {
			serviciosVigilante.registrarIngresoVehiculo(new Vehiculo("AAA111", "CARRO", 0));
			serviciosVigilante.registrarIngresoVehiculo(new Vehiculo("BBB22", "MOTO", 125));
			serviciosVigilante.registrarIngresoVehiculo(new Vehiculo("CCC333", "CARRO", 780));
			serviciosVigilante.registrarIngresoVehiculo(new Vehiculo("DDD444", "MOTO", 225));
		};
	}

}
