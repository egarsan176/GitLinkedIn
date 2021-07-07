package ejeHERENCIA.ejer3;

public abstract class Empleado {

	
	protected String nombre;
	protected int edad;
	protected String nif;
	protected double sueldo;
	
	public Empleado() {}

	public Empleado(String nombre, int edad, String nif, double sueldo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nif = nif;
		this.sueldo = sueldo;
	}
	
	public Empleado(String nombre, int edad, String nif) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nif = nif;
		
	}
	
	
	
	
	public abstract Double calcularSueldo();
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
	
	
}
