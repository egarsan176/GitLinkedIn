package relac10.AvanzPOO.ejer3_Juego.Excep;

public class ClerigoInteligenciaException extends Exception {

	public ClerigoInteligenciaException() {
		super("Un clerigo no puede tener una inteligencia menor a 12 ni mayor a 16.");
	}
}
