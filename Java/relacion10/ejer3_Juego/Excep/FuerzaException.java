package relac10.AvanzPOO.ejer3_Juego.Excep;

public class FuerzaException extends Exception {

	public FuerzaException() {
		super("Los valores de fuerza deben estar comprendidos entre 0 y 20.");
	}
}
