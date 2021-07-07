package ejeHERENCIA.ejer2;

public class Yate extends Deportiva {

	private int numCamarotes;
	
	public Yate() {
		super();
	}

	public Yate(String matricula, double eslora, int year, int pot, int camarotes) {
		super(matricula, eslora, year, pot);
		this.numCamarotes = camarotes;
		
	}

	
	
	public int getNumCamarotes() {
		return numCamarotes;
	}

	public void setNumCamarotes(int numCamarotes) {
		this.numCamarotes = numCamarotes;
	}

	@Override
	public double calcularAlquiler() {
		
		return super.calcularAlquiler()+this.numCamarotes+getPotencia();
	}

	
	
	
	
	
}
