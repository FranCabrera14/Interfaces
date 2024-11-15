package prueba;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Articulo> articulos = Articulo.createRandomList(20);
		System.out.println(articulos);
		
		
		// lista de  articulos tienen un stock mayor de 10
		
		List<Articulo> artMay10 = articulos.stream().filter(a -> a.getStock() > 10).toList();
		System.out.println(artMay10);
		
		//cuantos articulos tienen un stock mayor de 10
		
		Long cantidad = articulos.stream().filter(a -> a.getStock() > 10).count();
		System.out.println(cantidad);
		
		// quedarme con una lista de los codigos de articulo ordenados alfabeticamenbte
		
		List<String> codigos = articulos.stream()
				.filter(a -> a.getStock() > 10)
				.map(a -> a.getCodArticulo())
				.sorted()
				.toList();
		System.out.println(codigos);
		
		// que me imprima cual es el primer precio ordenado por mas caro
		
		Articulo art = articulos.stream()
		.filter(a -> a.getStock() > 10)
		.sorted((a1, a2) -> a1.getPrecio().compareTo(a2.getPrecio()))
		.findFirst().get();
		
		System.out.println(art);
		
		// condicion de si tengo algun articulo que sea mayor de 10
		
		if (articulos.stream().anyMatch(a -> a.getStock() > 10)) {
			System.out.println("Existe algun articulo con stock mayor a 10");
		}
		//dame todos los articulos mayor de 10 y dime si de esos hay alguno donde el precio sea mayor que 100
		
		Boolean x = articulos.stream()
				.filter(a -> a.getStock() > 10)
				.allMatch(a -> a.getStock() > 10);
		
		System.out.println(x);
		
		// cambiar precio y cambiarlo a 0
		
		articulos.stream().forEach(a -> a.setPrecio(0.));
		
		
		// para imprimir toda la lista
		
		articulos.forEach(a -> System.out.println(a));
		
	}
}
