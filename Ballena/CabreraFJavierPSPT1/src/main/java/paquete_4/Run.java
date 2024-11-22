package paquete_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

    public static void main(String[] args) {
        LogMensajes logMensajes = new LogMensajes();
       
        ExecutorService es = Executors.newFixedThreadPool(10);
        
        
        for (int i = 0; i < 100; i++) {
			Usuario user = new Usuario("Hola" + i, logMensajes);
			es.execute(user);
		}
       
       logMensajes.imprimirColaMensajes();
        // Crear y lanzar 10 usuarios como hilos

        
        // Esperar hasta fin de todos los hilos


        // Imprimir todos los mensajes registrados
        
    }
}