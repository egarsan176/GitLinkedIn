package repasoExamenes.exCOLLECTION.model;

import java.time.LocalDate;

public class Eolico extends AbstractGenerador {
	
	protected int numAspas;

	public Eolico(String localidad, double potencia, LocalDate fecha, int numAspas) {
		super(localidad, potencia, fecha);
		this.codigo = "Gen-"+CONTADOR_GENERADORES;
		this.numAspas = numAspas;
		CONTADOR_GENERADORES++;
		
	}

	public int getNumAspas() {
		return numAspas;
	}

	public void setNumAspas(int numAspas) {
		this.numAspas = numAspas;
	}

	@Override
	public String toString() {
		
		return super.toString() +
				"\nGENERADOR EÓLICO:"
				+ "\nNúmero de aspas: "+ getNumAspas() + ".";
	}

	@Override
	public double dinero(double precio) {
		
		return precio*getPotencia()*getNumAspas();
	}

	
	

}
