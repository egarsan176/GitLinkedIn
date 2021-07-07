package relac10.AvanzPOO.ejer5_Instalacion;

import java.util.ArrayList;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		
		
		
		Polideportivo p1 = new Polideportivo(1, 760, "Pabellón Fernando Martín");
		Polideportivo p2 = new Polideportivo(3, 325.5, "Piscina Cubierta Norte");
		Polideportivo p3 = new Polideportivo(5, 2500.36, "Estadio Felipe del Valle");
		
		EdificioOficina o1 = new EdificioOficina(25, 450.14);
		EdificioOficina o2 = new EdificioOficina(5, 200);
		
		
		//uso la interfaz Edificio porque ambas clases la comparten
		ArrayList<IEdificio> lista = new ArrayList<IEdificio>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(o1);
		lista.add(o2);
		
		//para mostrar el contenido
		Iterator<IEdificio> iterador = lista.iterator();
		while(iterador.hasNext())
			System.out.println(iterador.next()+"\n");
		
	}

}
