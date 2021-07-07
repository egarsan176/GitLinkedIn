package ejeHERENCIA.ejer2;

import java.time.LocalDate;

public abstract class Embarcacion {
	
	protected String matricula;
	protected double eslora;
	protected int year;
	
	public static final int VALOR_FIJO = 20;
	public static final int CONSTANTE = 10;
	
	public Embarcacion() {
		super();
	}
	/*como la clase abstracta no se puede instanciar, no es necesario hacerle un constructor*/
	public Embarcacion(String matricula, double eslora, int year) {
		super();
		this.matricula = matricula;
		this.eslora = eslora;
		this.year = year;
	}

	public double calcularAlquiler() {
		
		return (this.eslora*CONSTANTE)+VALOR_FIJO;
	}
	
	
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getEslora() {
		return eslora;
	}

	public void setEslora(double eslora) {
		this.eslora = eslora;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

}
