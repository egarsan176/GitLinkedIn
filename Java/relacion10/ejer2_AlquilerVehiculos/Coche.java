package relac10.AvanzPOO.ejer2_AlquilerVehiculos;

import relac10.AvanzPOO.ejer2_AlquilerVehiculos.CombustibleException;
import relac10.AvanzPOO.ejer2_AlquilerVehiculos.GamaException;

public class Coche extends AbstractVehiculo {
	

	private final static double SUPLEM_GASOLINA = 3.5;
	private final static int SUPLEM_DIESEL = 2;
	private String tipoCombustible;
	

	public Coche(String matricula, String tipoGama, String tipoCombustible) throws CombustibleException, GamaException {
		super(matricula, tipoGama);
		if(tipoCombustible.equalsIgnoreCase("GASOLINA") || tipoCombustible.equalsIgnoreCase("DIESEL")){
			this.tipoCombustible = tipoCombustible;
		} else {
			throw new CombustibleException();
		}
	}

	@Override
	public double calcularAlquiler() {
		double precio=0;
		
		if(getTipoCombustible().equalsIgnoreCase("GASOLINA") ) {
			precio = SUPLEM_GASOLINA;
		}
		else if(getTipoCombustible() == "DIESEL") {
			precio = SUPLEM_DIESEL;
		}
		return precio + super.calcularAlquiler();
	}

	public String getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(String tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	
	

	@Override
	public String toString() {
		return "Los datos de su coche son:"
				+ "\nTipo de combustible = " + tipoCombustible + "."
				+ "\nMatricula = " + matricula + "."
				+ "\nGama =" + tipoGama
				+ ".";
	}
	
	
	

}
