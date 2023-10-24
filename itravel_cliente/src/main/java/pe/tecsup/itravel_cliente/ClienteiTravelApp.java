package pe.tecsup.itravel_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClienteiTravelApp {

	public static void main(String[] args) {
		// Inicia la aplicación Spring Boot del cliente
		SpringApplication.run(ClienteiTravelApp.class, args);
	}


	// Configuración de un bean RestTemplate para realizar solicitudes HTTP
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
