package com.project.citiesapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		//Informaçoes que vai ser usadas no cabeçalho do swagger
		info = @Info(title = "API Calculadora de Distancias", version = "3.0.1",
				description = "API que calcula a distancia entre duas cidades brasileiras. "),
		servers = {
				@Server(url = "http://localhost:8080"), //Url e porta utilizada pela API
		}
)
public class CitiesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitiesApiApplication.class, args);
	}

}
