package ejeHERENCIA.ejer2;

public class Cliente {

	private String nombre;
	private String dni;
	
	public Cliente() {}
	
	public Cliente(String n, String dni) {
		super();
		this.nombre = n;
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "El cliente" + this.nombre + "con DNI" + this.dni;
	}
	
	
	
}
