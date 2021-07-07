package repasoExamenes.exCOLLECTION.model;

import java.time.LocalDate;

public class Solar extends AbstractGenerador {
	
	protected int numPaneles;
	protected double metrosPaneles;
	protected ETipoGeneradorSolar tipo;

	public Solar(String localidad, double potencia, LocalDate fecha, int numPaneles, double metrosPaneles, ETipoGeneradorSolar tipo) {
		super(localidad, potencia, fecha);
		this.codigo = "Gen-"+CONTADOR_GENERADORES;
		this.numPaneles = numPaneles;
		this.metrosPaneles = metrosPaneles;
		this.tipo = tipo;
		CONTADOR_GENERADORES++;
	}

	public int getNumPaneles() {
		return numPaneles;
	}

	public void setNumPaneles(int numPaneles) {
		this.numPaneles = numPaneles;
	}

	public double getMetrosPaneles() {
		return metrosPaneles;
	}

	public void setMetrosPaneles(double metrosPaneles) {
		this.metrosPaneles = metrosPaneles;
	}

	public ETipoGeneradorSolar getTipo() {
		return tipo;
	}

	public void setTipo(ETipoGeneradorSolar tipo) {
		this.tipo = tipo;
	}
	
	public double obtenerCoeficienteSolar() {
		
		return getMetrosPaneles()/getNumPaneles();
	}

	@Override
	public String toString() {
		
		return super.toString()+
				"\nGENERADOR SOLAR:"
				+ "\nNúmero de paneles: "+getNumPaneles()
				+ "\nMetros cuadrados de todos los paneles: " +getNumPaneles()
				+ "\nTipo: "+getTipo()
				+ "\nCoeficiente solar: " + obtenerCoeficienteSolar();
	}

	@Override
	public double dinero(double precio) {
		
		return precio*getPotencia()*getNumPaneles();
	}

	
	

}
