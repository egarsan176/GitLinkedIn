package ejeHERENCIA.ejer3;

import java.time.LocalDate;

public class EmpleadoFijo extends Empleado {

	private int yearAlta;
	
	private static final int COMPLEMENTO = 20;
	
	
	public EmpleadoFijo(String nombre, int edad, String nif, double sueldo, int yearAlta) {
		super(nombre, edad, nif, sueldo);
		this.yearAlta = yearAlta;
	}


	public int getYearsEmpresa() {
		
		int year = LocalDate.now().getYear();
		
		return year - this.getYearAlta();
	}

	@Override
	public Double calcularSueldo() {
		
		return super.getSueldo()+(COMPLEMENTO*getYearsEmpresa());
	}


	public int getYearAlta() {
		return yearAlta;
	}
	
	

}
