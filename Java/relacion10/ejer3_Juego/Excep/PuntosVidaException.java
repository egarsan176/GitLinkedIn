package relac10.AvanzPOO.ejer3_Juego.Excep;

public class PuntosVidaException extends Exception {
	
	public PuntosVidaException() {
		super("Los valores para los puntos de vida deben estar comprendidos entre 0 y 100");
	}

}
