package paquete_1_5;

public class Run {
	public static void main(String[] args) {
		SorteoSimulator s1 = new SorteoSimulator("bonoloto española", 1, 49, 5);
		s1.generaUnaCombinaciónGanadora(300);
		RSorteoSimulator rs1 = new RSorteoSimulator("bonoloto francesa", 1, 49, 5);
		
		TsorteoSimulator ts1 = new TsorteoSimulator("bonoloto italiana", 1, 90, 5);
		ts1.start();
	}

}
