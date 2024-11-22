package examen.dao;

import java.util.HashMap;
import java.util.Map;

public class PaisesDao {

	// AQUÍ NO TIENES QUE HACER NADA. NO PUEDES AÑADIR MÁS MÉTODOS. 
	// SI NECESITAS CONSULTAR LOS PAÍSES O UN PAÍS, UTILIZA ESTE MÉTODO QUE TIENES AQUÍ.
	// DEVUELVE UN MAP DONDE LA CLAVE ES EL CÓDIGO DEL PAÍS Y EL VALOR ES LA DESCRIPCIÓN.
	
	public Map<String, String> getAllMapPaises(){
		Map<String, String> paises = new HashMap<>();
		paises.put("ES", "España");
		paises.put("FR", "Francia");
		paises.put("IT", "Italia");
		paises.put("UK", "Reino Unido");
		paises.put("EC", "Ecuador");
		paises.put("PT", "Portugal");
		return paises;
	}

}
