package ejeHERENCIA.ejer3;

public class EmpleadoPorHoras extends Empleado {

	private double precioHora;
	private double numeroHorasTrabajadas;
	
	
	
	public EmpleadoPorHoras(String nombre, int edad, String nif, double precioHora, double numeroHorasTrabajadas) {
		super(nombre, edad, nif);
		this.precioHora = precioHora;
		this.numeroHorasTrabajadas = numeroHorasTrabajadas;
		this.sueldo = calcularSueldo();
	}



	@Override
	public Double calcularSueldo() {
		
		return this.getPrecioHora() * this.getNumeroHorasTrabajadas();
	}



	public double getPrecioHora() {
		return precioHora;
	}


	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}


	public double getNumeroHorasTrabajadas() {
		return numeroHorasTrabajadas;
	}


	public void setNumeroHorasTrabajadas(double numeroHorasTrabajadas) {
		this.numeroHorasTrabajadas = numeroHorasTrabajadas;
	}
	
	

}
