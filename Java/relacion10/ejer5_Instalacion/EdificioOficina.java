package relac10.AvanzPOO.ejer5_Instalacion;

public class EdificioOficina implements IEdificio {
	
	private int numeroOficinas;
	private double superficie;
	
	public  EdificioOficina(int numeroOficinas, double superficie) {
		this.numeroOficinas = numeroOficinas;
		this.superficie = superficie;
	}

	@Override
	public double getSuperficieEdificio() {
		
		return superficie;
	}

	public int getNumeroOficinas() {
		return numeroOficinas;
	}

	public void setNumeroOficinas(int numeroOficinas) {
		this.numeroOficinas = numeroOficinas;
	}
	
	@Override
	public String toString() {
		return "El edificio tiene un total de " + getNumeroOficinas() + " oficinas y una superficie de " 
				+ getSuperficieEdificio()+" m2.";
	}
	
	

}
