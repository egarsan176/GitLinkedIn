package ejeHERENCIA.ejer1;

public class Titular {

	private String nombre;
	protected int edad;
	
	public Titular() {}

	public Titular(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "El titular es " + this.nombre + "y su edad es "+this.edad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	

	
}
