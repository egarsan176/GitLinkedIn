package galaxia;

public class Pelicula {

	private String nombre;
	private int yearEstreno;
	private Personaje p1;
	private Personaje p2;
	private Personaje p3;
	
	public Pelicula() {}
	
	public Pelicula (String nombre, int yearEstreno, Personaje p1, Personaje p2, Personaje p3) {
		this.nombre = nombre;
		this.yearEstreno = yearEstreno;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	/**
	 * Este método compara el año de estreno de dos películas
	 * @param peli
	 * @return Devuelve un mensaje con el nombre de la película más nueva
	 */
	public String compararPelicula(Pelicula peli) {
		String mensaje = "";
		if(this.yearEstreno > peli.yearEstreno) {
			mensaje = "La película <"+this.nombre + "> es más nueva que la película <" +peli.nombre +">.";
		}else if(this.yearEstreno < peli.yearEstreno) {
			mensaje = "La película <"+peli.nombre + "> es más nueva que la película <" +this.nombre +">.";
		}else if(this.yearEstreno == peli.yearEstreno) {
			mensaje = "La fecha de ambas películas es igual.";
		}
		
		
		return mensaje;
	}
	/**
	 * este método nos dice cual es el poder máximo de una película (el poder máximo de cada
uno de los personajes que tenga asignado)
	 * @return devuelve un string con el poder maximo de cada personaje
	 */
	public String obtenerPoderMaximoPelicula() {
		
		return "El poder máximo de la película es: "+this.p1.getPoderDes() +", "
													+this.p2.getPoderDes() +", "
													+this.p3.getPoderDes() +".";
	}

	/**
	 * este método nos dice el poder de la película (todos los poderes de los personajes)
	 * @return devuelve un string con la suma de los poderes de los personajes
	 */
	public String obtenerPoderPelicula() {
		return "El poder de la película es: " + (this.p1.getPoderDes()+this.p2.getPoderDes()+this.p3.getPoderDes()) +".";
	}
	
	
	
	public String toString() {
		
		String posicion=this.getP1().getNombre();
		String P2 = this.getP2().getNombre();
		String P3 = this.getP3().getNombre();
		
		//<0 si cad1=A cad2=B    >0 si cad1=B cad2=A
		if(posicion.compareTo(P2)>=0){
			
			posicion = P2 + ", " + posicion;
			
		}else {
			posicion = posicion + ", " + P2;
					
		}
		
		if(posicion.compareTo(P3)>=0){
			
			posicion = P3 + ", " + posicion;
			
		}else {
			posicion = posicion + ", " + P3;
					
		}
		
		
		return this.nombre + " (" + this.yearEstreno + "), " + posicion +".";
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getYearEstreno() {
		return yearEstreno;
	}

	public void setYearEstreno(int yearEstreno) {
		this.yearEstreno = yearEstreno;
	}

	public Personaje getP1() {
		return p1;
	}

	public void setP1(Personaje p1) {
		this.p1 = p1;
	}

	public Personaje getP2() {
		return p2;
	}

	public void setP2(Personaje p2) {
		this.p2 = p2;
	}

	public Personaje getP3() {
		return p3;
	}

	public void setP3(Personaje p3) {
		this.p3 = p3;
	}

	
	
	

	
}
