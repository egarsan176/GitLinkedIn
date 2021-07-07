package relac10.AvanzPOO.ejer2_AlquilerVehiculos;

public class CombustibleException extends Exception {

	public CombustibleException() {
		super ("El combustible seleccionado no se encuentra entre las opciones disponibles.");
	}
}
