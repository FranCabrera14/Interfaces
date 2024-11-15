package ejercicio5Multihilo;

import java.util.TimerTask;

import lombok.Data;
@Data

public class EmisorTimerTask extends TimerTask {

	private DefinicionEmisor definicionEmisor;
	private Integer pulsos;
	
	
	
	public EmisorTimerTask(DefinicionEmisor definicionEmisor) {
		super();
		this.definicionEmisor = definicionEmisor;
		this.pulsos = definicionEmisor.getPulsos();
	}

	@Override
	public void run() {
		if (pulsos > 0 ) {
			definicionEmisor.emiteUnitariamente();
			pulsos --;
		}else {
			cancel();
		}
	}





}
