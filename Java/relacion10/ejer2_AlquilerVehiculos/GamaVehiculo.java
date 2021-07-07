package relac10.AvanzPOO.ejer2_AlquilerVehiculos;

public enum GamaVehiculo {
	
	BAJA(30),
	MEDIA(40),
	ALTA(50);
	
	private int precioGama;
	
	GamaVehiculo(int precio) {
		this.precioGama = precio;
	}

	public int getPrecio() {
		return precioGama;
	}

}
