package es.corona.comp;

import java.util.Comparator;

import es.corona.model.Corona;

public class Curados implements Comparator<Corona> {
	
	@Override
	public int compare(Corona o1, Corona o2) {
		
		//ordena de mayor a menor
		
		int aux = 0;
		
		if(o1.getCurados()>o2.getCurados()) {
			aux = 1;
		}else if(o1.getCurados()<o2.getCurados()) {
			aux = -1;
		}
		
		return aux;
	}

}
