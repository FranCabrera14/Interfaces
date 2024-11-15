package ejercicioReservaEntrada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        // Crear el sistema de reserva
        SistemaReserva sistemaReserva = new SistemaReserva();

        // Agregar eventos al sistema
        sistemaReserva.agregarEvento("Concierto Rock", 50);
        sistemaReserva.agregarEvento("Concierto Jazz", 10000);
        
        //ExecutorService es = Executors.newSingleThreadExecutor();
        List<Thread> hilos = new ArrayList<>();
        for (int i = 0; i <  1000; i++) {
			//es.execute(new Usuario(sistemaReserva, "Jose" + i , "Concierto Rock", 10));
        	Thread t1 = new Thread(new Usuario(sistemaReserva, "Cristian " + i , "Concierto Jazz", 12));
        	t1.start();
        	hilos.add(t1);
		}
        
        for (Thread thread : hilos) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
        
        System.out.println("MATENME");
        
        // Crear hilos de usuarios intentando reservar entradas
//        Thread usuario1 = new Thread(new Usuario(sistemaReserva, "Usuario1", "Concierto Rock", 4));
//        Thread usuario2 = new Thread(new Usuario(sistemaReserva, "Usuario2", "Concierto Rock", 6));
//        Thread usuario3 = new Thread(new Usuario(sistemaReserva, "Usuario3", "Concierto Rock", 3));
//        Thread usuario4 = new Thread(new Usuario(sistemaReserva, "Usuario4", "Concierto Jazz", 2));
//        Thread usuario5 = new Thread(new Usuario(sistemaReserva, "Usuario5", "Concierto Jazz", 4));

        // Iniciar los hilos
//        usuario1.start();
//        usuario2.start();
//        usuario3.start();
//        usuario4.start();
//        usuario5.start();

        // Esperar a que los hilos terminen
//        try {
//            usuario1.join();
//            usuario2.join();
//            usuario3.join();
//            usuario4.join();
//            usuario5.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // Mostrar cuántas entradas quedan disponibles después de las reservas
//        System.out.println("Entradas restantes para Concierto Rock: " + sistemaReserva.entradasRestantes("Concierto Rock"));
//        System.out.println("Entradas restantes para Concierto Jazz: " + sistemaReserva.entradasRestantes("Concierto Jazz"));
    }

}
