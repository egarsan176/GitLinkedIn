package repasoExamenes.exCOLLECTION.model;

import java.util.Comparator;

public class OrdenaLocalidad implements Comparator<AbstractGenerador>{

	@Override
	public int compare(AbstractGenerador o1, AbstractGenerador o2) {
		int aux;
		
		//comparo localidades y devuelvo el resutado
		aux = o1.getLocalidad().compareTo(o2.getLocalidad());
		
		//si son la misma localidad, ordeno por fecha
		if(aux == 0) {
			if(o1.getFecha().isAfter(o2.getFecha())) {
				aux = 1;
			}
			else if(o1.getFecha().isBefore(o2.getFecha())) {
				aux = -1;
			}
			else {
				aux = 0;
			}
		}
		
		return aux;
	}

}
