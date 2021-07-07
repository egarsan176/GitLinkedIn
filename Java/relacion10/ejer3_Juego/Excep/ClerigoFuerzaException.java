package relac10.AvanzPOO.ejer3_Juego.Excep;

public class ClerigoFuerzaException extends Exception {

	public ClerigoFuerzaException() {
		super("Un clérigo no puede tener una fuerza inferior a 18.");
	}
}
