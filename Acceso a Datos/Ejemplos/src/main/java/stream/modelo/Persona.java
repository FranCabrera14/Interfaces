package stream.modelo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	private String nombre;
	private Integer edad;
	
	
	
	public static Persona createRandom() {
		Random random = new Random();
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Integer tamañoNombre = random.nextInt(6, 20);
        
		String nombreAleatorio = Stream.generate(() -> random.nextInt(alfabeto.length()))
			.map(i -> alfabeto.substring(i, i+1))
			.limit(tamañoNombre)
			.collect(Collectors.joining());
		
        return new Persona(nombreAleatorio, random.nextInt(1, 99));
	}
	
	
	public static List<Persona> createRandomList(Integer tamaño){
		return Stream.generate(() -> createRandom())
				.limit(tamaño)
				.toList();
	}
	
	
}
