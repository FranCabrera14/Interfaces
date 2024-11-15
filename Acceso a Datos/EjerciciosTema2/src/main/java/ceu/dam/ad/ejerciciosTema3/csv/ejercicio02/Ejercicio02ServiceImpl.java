package ceu.dam.ad.ejerciciosTema3.csv.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import appServices.modelo.User;
import appServices.services.UserService;
import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;


public class Ejercicio02ServiceImpl implements Ejercicio02Service {

	private static final Logger log = LoggerFactory.getLogger(Ejercicio02ServiceImpl.class);
	
	@Override
	public void importarUsuarioCSV(String nombreFichero) throws CsvException {
		try {
			log.info("Importanto fichero de usuarios " + nombreFichero);
			File file = new File(nombreFichero);
			Scanner scanner = new Scanner(file);
			UserService userService = new UserService();
			Integer numLinea = 0;
			Integer numLineaError = 0;
			
			while( scanner.hasNext()) {
				User user = new User();
				numLinea++;
				try {
					String linea = scanner.nextLine();
					String[] lineaTroceada = linea.split("\t");
					user.setUserName(lineaTroceada[0]);
					user.setPassword(lineaTroceada[1]);
					user.setEmail(lineaTroceada[2]);
					userService.registerUser(user);
				}
				catch(Exception e) {
					numLineaError++;
					log.warn("Error creando el usuario de la línea  " + numLinea + ". Se continuará con el resto de líneas", e);
				}
			}
			
			log.info("Se ha importando fichero de usuarios: Líneas totales: " + numLinea + " Erróneas: " + numLineaError);
			scanner.close();
			
		} catch (FileNotFoundException e) {
			log.error("Error leyendo fichero de usuarios. El fichero no existe.", e);
			throw new CsvException("Error leyendo fichero de usuarios. El fichero no existe." ,e);
		}
		
	}

}
