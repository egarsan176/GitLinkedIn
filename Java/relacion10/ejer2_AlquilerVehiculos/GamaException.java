package relac10.AvanzPOO.ejer2_AlquilerVehiculos;

public class GamaException extends Exception {

	public GamaException() {
		super("La gama seleccionada no se encuentra entre las opciones disponibles.");
	}
}
