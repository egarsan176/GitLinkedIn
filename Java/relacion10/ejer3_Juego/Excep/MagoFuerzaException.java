package relac10.AvanzPOO.ejer3_Juego.Excep;

public class MagoFuerzaException extends Exception {

	public MagoFuerzaException() {
		super("Un mago no puede tener una fuerza superior a 15.");
	}
}
