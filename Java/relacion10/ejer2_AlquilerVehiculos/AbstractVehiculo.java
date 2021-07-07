package relac10.AvanzPOO.ejer2_AlquilerVehiculos;

import relac10.AvanzPOO.ejer2_AlquilerVehiculos.GamaException;
import relac10.AvanzPOO.ejer2_AlquilerVehiculos.GamaVehiculo;

public abstract class AbstractVehiculo {
	
	protected String matricula;
	protected String tipoGama;
	
	public AbstractVehiculo(String matricula, String tipoGama) throws GamaException{
		this.matricula = matricula;
		if(tipoGama.equalsIgnoreCase("BAJA") || tipoGama.equalsIgnoreCase("MEDIA") || tipoGama.equalsIgnoreCase("ALTA")){
			this.tipoGama = tipoGama;
		} else {
			throw new GamaException();
		}
		
	}
	
	public  double calcularAlquiler() {
		
		double precioBase = 0.0;
		
		if(getTipoGama().equalsIgnoreCase("BAJA")) {
			precioBase = GamaVehiculo.BAJA.getPrecio();
		}else if(getTipoGama().equalsIgnoreCase("MEDIA")) {
			precioBase = GamaVehiculo.MEDIA.getPrecio();
		}else if(getTipoGama().equalsIgnoreCase("ALTA")) {
			precioBase = GamaVehiculo.ALTA.getPrecio();
		}
		return precioBase;
	}
	
	
	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipoGama() {
		return tipoGama;
	}

	public void setTipoGama(String tipoGama) {
		this.tipoGama = tipoGama;
	}
	
	
	

}
