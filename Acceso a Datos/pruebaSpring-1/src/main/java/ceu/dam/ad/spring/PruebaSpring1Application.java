package ceu.dam.ad.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.spring.model.Actor;
import ceu.dam.ad.spring.service.ActorNotFoundException;
import ceu.dam.ad.spring.service.ActorService;
import ceu.dam.ad.spring.service.ActorServiceException;

@SpringBootApplication
public class PruebaSpring1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PruebaSpring1Application.class, args);
		//para instanciarlo
		ActorService service = context.getBean(ActorService.class);
		
		try {
			System.out.println(service.consultarActor(8L));
		} catch (ActorNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Actor a1 = new Actor();
		try {
			a1 = service.consultarActor(207L);
		} catch (ActorNotFoundException e) {
			
			e.printStackTrace();
		}

		a1.setLastName("OS ODIO A LOS DOS ");
//		Actor b = new Actor();
//		
//		b.setFirstName("HOSELITO pito pito gorgorito lo tienes mu chiquito jajajaj xd natalia te odio dile a tu madre que no le voy a pasar la pension");
//		b.setLastName("De los Rizos Rizados");	
//		
//		List<Actor> lista = new ArrayList<Actor>();
//		lista.add(a);
//		lista.add(b);
//		try {
//			service.crearActores(lista);
//		} catch (ActorServiceException e) {
//			System.out.println("Error insertando actor");
//	
//			
//		}
		service.actualizarActor(a1);
		service.borrarActor(203L);
//		System.out.println(a);
	}

}
