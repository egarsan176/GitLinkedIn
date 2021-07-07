package ejeHERENCIA.ejer3;

import java.time.LocalDate;

public class EmpleadoTemporal extends Empleado {
	
	private LocalDate fechaAlta;
	private LocalDate fechaBaja;
	
	

	public EmpleadoTemporal(String nombre, int edad, String nif, double sueldo, LocalDate fechaAlta, LocalDate fechaBaja) {
		super(nombre, edad, nif, sueldo);
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}



	@Override
	public Double calcularSueldo() {
		
		return super.getSueldo();
	}

}
