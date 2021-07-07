package ejeHERENCIA.ejer1;

public enum Bonificacion {

	CUENTA_JOVEN(0.25),
	CUENTA_NORMAL(0.0);
	
	private double bonificacion;
	
	Bonificacion(double b) {
		this.bonificacion = b;
	}
	
	public double getBonificacion() {
		return bonificacion;
	}

	
}
