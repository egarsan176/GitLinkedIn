package galaxia;

public class Personaje {

	private String nombre;
	private double poderDes;
	private Pelicula pelicula;
	private double estatura;
	private String especie;
	private double peso;
	
	public Personaje() {}
	
	public Personaje(String nombre, double poderDes, Pelicula pelicula, double estatura, String especie, double peso) {
		
		this.nombre = nombre;
		this.poderDes = poderDes;
		this.pelicula = pelicula;
		this.estatura = estatura;
		this.especie = especie;
		this.peso = peso;	
		
	}

	
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPoderDes() {
		return poderDes;
	}


	public void setDestruccion(int poderDes) { //el poder de destruccion tiene q ser entre 1-100
		if(poderDes>=1 && poderDes<=100) {
			this.poderDes = poderDes;
		}
		
	}
	
	/**
	 * mostrar el nombre, la estatura, la especie, y a
continuación lo que sea mayor, la capacidad de destrucción o el peso
	 */
	@Override
	public String toString() {
		String mensaje = "";
		
		if(this.poderDes>this.peso) {
			mensaje = "El nombre del personaje es: "+this.nombre + ","
					+ " su estatura es: " + this.estatura + ","
					+ " pertenece a la especie: " + this.especie + ","
					+ " y su poder de destrucción es: " + this.poderDes +".";
		}
		else if (this.poderDes<this.peso) {
			mensaje = "El nombre del personaje es: "+this.nombre + ","
					+ " su estatura es: " +this.estatura + ","
					+ " pertenece a la especie: " +this.especie + ","
					+ " y su peso es: " + this.peso +".";
		}
		
		return mensaje;
	}


	public Pelicula getPelicula() {
		return pelicula;
	}


	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	public double getEstatura() {
		return estatura;
	}


	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
