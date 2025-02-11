package paquete_1_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SorteoSimulator {
	private String nombreSorteo;
	private Integer numBolaInicial;
	private Integer numBolaFinal;
	private Integer bolasExtraer;
	
	public SorteoSimulator(String nombreSorteo, Integer numBolaInicial, Integer numBolaFinal, Integer bolasExtraer) {
		super();
		this.nombreSorteo = nombreSorteo;
		this.numBolaInicial = numBolaInicial;
		this.numBolaFinal = numBolaFinal;
		this.bolasExtraer = bolasExtraer;
	}
	
	@Override
	public String toString() {
		return "Sorteo " + nombreSorteo + " desde la bola " + numBolaInicial + " a la " + numBolaFinal + " donde se extraen " + bolasExtraer + " bolas.\n"
				;
	}
	
	public void generaUnaCombinaciónGanadora(long milis) {
		
		List <Integer >bombo = new ArrayList<Integer>();
		List <Integer> resultado = new ArrayList<Integer>();
		for (int i = 1; i <= numBolaFinal; i++) {
			bombo.add(i);
		}
		   Collections.shuffle(bombo);
		   
		   for (int i = 0; i < bombo.size(); i++) {
			resultado.add(bombo.get(i));
		}
		while(bolasExtraer > 0) {
			try {
				Thread.sleep(milis);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bolasExtraer--;
			System.out.println("\t - " + nombreSorteo);
		}
		
		
	}


	
	

}
