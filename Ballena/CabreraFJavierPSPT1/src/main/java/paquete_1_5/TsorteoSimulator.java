package paquete_1_5;

public class TsorteoSimulator extends Thread {
	private String nombreSorteo;
	private Integer numBolaInicial;
	private Integer numBolaFinal;
	private Integer bolasExtraer;
	private SorteoSimulator sorteo;


	public TsorteoSimulator(String nombreSorteo, Integer numBolaInicial, Integer numBolaFinal, Integer bolasExtraer) {
		sorteo = new SorteoSimulator(nombreSorteo, numBolaInicial, numBolaFinal, bolasExtraer);
	}



	@Override
	public void run() {
		sorteo.generaUnaCombinaciónGanadora(300);
	}



}
