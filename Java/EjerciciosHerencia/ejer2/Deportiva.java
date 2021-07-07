package ejeHERENCIA.ejer2;

public class Deportiva extends Embarcacion {

	private int potencia;
	
	public Deportiva() {
		super();
	}

	public Deportiva(String matricula, double eslora, int year, int pot) {
		super(matricula, eslora, year);
		this.potencia = pot;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public double calcularAlquiler() {
		
		return super.calcularAlquiler()+this.potencia;
	}
	
	
	
	
	
	
	
}
