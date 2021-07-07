package es.corona.comp;

import java.util.Comparator;

import es.corona.model.Corona;

public class Fallecidos implements Comparator<Corona> {

	@Override
	public int compare(Corona o1, Corona o2) {
		
		//ordena de menor a mayor
		
		int aux = 0;
		
		if(o1.getFallecidos()>o2.getFallecidos()) {
			aux = -1;
		}else if(o1.getFallecidos()<o2.getFallecidos()) {
			aux = 1;
		}
		
		return aux;
	}

}
