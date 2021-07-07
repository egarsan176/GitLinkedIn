package relac10.AvanzPOO.ejer3_Juego.Excep;

public class RazaException extends Exception {
	
	public RazaException() {
		super("La raza seleccionada no se encuentra entre las opciones disponibles.");
	}

}
