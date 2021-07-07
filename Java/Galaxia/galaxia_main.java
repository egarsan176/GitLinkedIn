package galaxia;

public class galaxia_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Pelicula pel = new Pelicula();
		Personaje p1 = new Personaje("Yoda", 29, pel, 60, "Yoda", 15);
		Personaje p2 = new Personaje("Luke Skywalker", 67, pel, 180, "humano", 80);
		Personaje p3 = new Personaje("Chewbacca", 54, pel, 214, "wookiee", 110);

		
		System.out.println(p1.toString());
		
		
		Pelicula peli = new Pelicula("Star Wars: Episodio IV - Una nueva esperanza", 1977, p1, p2, p3);
		Pelicula peli2 = new Pelicula("Star Wars: Episodio I - La amenaza fantasma", 1999, p1, p2, p3);
		
		System.out.println(peli.compararPelicula(peli2));
		
		//pelicula pelicula = new pelicula("SW", 2018, p1, p2, p3);
		//pelicula peliculita = new pelicula("SWII", 2018, p1, p2, p3);
		
		//System.out.println(pelicula.compararPelicula(peliculita));
		
		
		System.out.println(peli.obtenerPoderMaximoPelicula());
		
		System.out.println(peli.obtenerPoderPelicula());
		
		
		//System.out.println(p1.getNombre().compareTo(p2.getNombre()));
		
		
		System.out.println(peli.toString());
	}
	
	

}
