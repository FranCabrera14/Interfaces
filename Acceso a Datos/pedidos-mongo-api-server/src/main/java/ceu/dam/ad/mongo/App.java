package ceu.dam.ad.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.services.ClienteServiceImpl;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		ClienteServiceImpl service = context.getBean(ClienteServiceImpl.class);
		
	
	}

}
