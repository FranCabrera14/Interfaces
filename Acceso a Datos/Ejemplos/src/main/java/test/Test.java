package test;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import stream.modelo.Persona;

public class Test {

	public static void main(String[] args) {
		
		List<Persona> personas = Stream.generate(()->new Persona()).limit(100).toList();
		
		Random r = new Random();
		List<Integer> numeros = Stream.generate(() -> r.nextInt(100)).limit(10).toList();		
		System.out.println(numeros);
		
		
	}
}
