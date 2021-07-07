package relac10.AvanzPOO.ejer2_AlquilerVehiculos;

import relac10.AvanzPOO.ejer2_AlquilerVehiculos.GamaException;

public class Microbus extends AbstractVehiculo {

	private int numPlazas;
	private final static int SUPLEM_MICRO = 5;
	

	public Microbus(String matricula, String tipoGama, int plazas) throws GamaException {
		super(matricula, tipoGama);
		this.numPlazas = plazas;
	}
	
	@Override
	public double calcularAlquiler() {
		
		return super.calcularAlquiler()+(getNumPlazas()*SUPLEM_MICRO) ;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}


	@Override
	public String toString() {
		return "Los datos del Microbus son: "
				+ "\nNúmero de plazas = " + numPlazas + "."+
				"\nMatricula = " + matricula + "."
				+ "\nGama = " + tipoGama + ".";
	}
}
