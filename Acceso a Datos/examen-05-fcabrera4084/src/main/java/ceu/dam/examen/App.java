package ceu.dam.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.examen.test.TestService;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args); // estabas arrancando dos veces
		TestService test = context.getBean(TestService.class);
		test.test();
	}

}
