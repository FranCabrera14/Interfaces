package paquete_4;

import java.util.Random;



public class Usuario implements Runnable{

	private String nombre;
	// Para enlazar el log de mensajes a usar
	private LogMensajes logMensajes;
	// Para gestionar el próximo ID de mensajes de usuario
	private static Long nextIdMensaje = 0L; 


	public Usuario(String nombre, LogMensajes logMensajes) {
		this.nombre = nombre;
		this.logMensajes = logMensajes;
	}

	public  void enviarMensajes(LogMensajes logMensajes) {
		// Ciclo continuo para enviar 100 mensajes con esperas aleatorias
		for (int i = 0; i < 10000; i++) {
			enviarMensaje();
			pausar();
		}

	}

	public synchronized void enviarMensaje() {
		// Registra un nuevo ID de mansaje en la lista de mensajes en logMensajes
		nextIdMensaje++;
		logMensajes.registrarMensaje(nextIdMensaje);

	}

	public void pausar() {
		Random r = new Random(200);
		try {
			Thread.sleep(r.nextLong()+2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Pausa entre mensajes de 200 a 400 milisegundos
	}

	@Override
	public void run() {
		enviarMensaje();
		
	}

}
