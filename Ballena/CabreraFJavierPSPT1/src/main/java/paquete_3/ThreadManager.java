package paquete_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ThreadManager {

    private List<Thread> threads = new ArrayList<>();
    private TreeMap<Long, String> threadStates = new TreeMap<>();
    private Thread h1;
    private Thread h2;
    private Thread h3;
    

    public void startThreads() {
        // Crea tres hilos CountDown con diferentes valores iniciales
        // y añádelos a la lista threads. Valores: 
    	  //   - "C1", 10
    	  //   - "C2", 8
    	  //   - "C3", 7


        // Inicia los hilos recorriendo la lista threads
        
        // Guarda el estado de cada hilo en el Map
    	CountDown c1 = new CountDown("C1", 10);
    	CountDown c2 = new CountDown("C2", 8);
    	CountDown c3 = new CountDown("C3", 7);
    	
    	 h1 = new Thread(c1);
    	 h2 = new Thread(c2);
    	 h3 = new Thread(c3);
    	threads.add(h1);
    	threads.add(h2);
    	threads.add(h3);
    	
    	for (Thread thread : threads) {
    		thread.start();
			threadStates.put(System.currentTimeMillis(), h1.getState().toString());
			threadStates.put(System.currentTimeMillis(), h2.getState().toString());
			threadStates.put(System.currentTimeMillis(), h3.getState().toString());
		}
    }

    public void monitoreaThreads() throws InterruptedException {
        boolean allThreadsTerminated = false;
        
        while (!allThreadsTerminated) {
        	if(h1.isAlive() && h2.isAlive() && h2.isAlive()) {
        		Thread.sleep(90);
        		threadStates.put(System.currentTimeMillis(), h1.getName() + h1.getState().toString());
        		threadStates.put(System.currentTimeMillis(), h2.getName() + h2.getState().toString());
        		threadStates.put(System.currentTimeMillis(), h3.getName() + h3.getState().toString());
        	}else {
        		allThreadsTerminated = true;
        	}
        	
        	
        	
        }
        // Monitorea hasta que todos los hilos hayan terminado.
        // Para ello cada 90 milisegundos aproximadamente
        // almacena en el map para cada hilo la información:
        //    - clave -> timestamp 
        //    - valor -> cadena con nombre y estado 
        //    - ejemplo de la cadena: C1:RUNNABLE
        // y vefica si todos han terminado.
        
    }

    public void printThreadStates() {
        // Imprimir todos los estados registrados en el TreeMap
        System.out.println("\nResumen de estados de los hilos:");
        for (Map.Entry<Long, String> entry : threadStates.entrySet()) {
			System.out.println(entry.toString());
			
		}
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadManager manager = new ThreadManager();
        manager.startThreads();
        manager.monitoreaThreads();
        manager.printThreadStates();
        // Responde brevemente a las siguientes preguntas:
        //  1.- Motivo de la frecuencia del estado RUNNABLE
        //  2.- Motivo de la frecuencia del estado TIMED_WAITING
        //  3.- Motivo de la frecuencia del estado TERMINATED
        System.out.println("Respuestas a las preguntas");
        System.out.println("1: empieza un hilo y hasta que no acaba no empieza el otro");
        System.out.println("2: Al no tener ningun metodo sinchronized los hilos esperan hasta que el que va delante acabe el proceso");
        System.out.println("3: Se da este etado cuando el hilo ha terminado su ejecicon y ha dejado de funcionar.");       
    }
}
