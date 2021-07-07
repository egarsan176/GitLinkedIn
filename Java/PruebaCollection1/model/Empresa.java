package repasoExamenes.exCOLLECTION.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import repasoExamenes.exCOLLECTION.excep.AddGeneradorException;
import repasoExamenes.exCOLLECTION.excep.BorrarGeneradorExcepcion;

public class Empresa {
	
	private String nombre;
	private Set<AbstractGenerador> generadores;
	//utilizo un HashSet porque el enunciado dice que no puede haber generadores repetidos
	
	
	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
		this.generadores = new HashSet<AbstractGenerador>();
	} 
	
	//anade un generador nuevo
	public void addGenerador(AbstractGenerador generador) throws AddGeneradorException {

		if(generadores.contains(generador)) {
			throw new AddGeneradorException();
		}else {
			generadores.add(generador);
		}
	}
	
	//mostrar generadores eolicos
	public String mostrarGeneradoresEolicos() {
		StringBuilder sb = new StringBuilder("Listado de generadores eólicos de la empresa "+ getNombre()+": \n");
		
		for(AbstractGenerador generador: generadores) {
			if(generador instanceof Eolico) {
				sb.append("\n\t> "+generador+"\n");
			}
		}
			
		return sb.toString();
	}
	
	//mostrar generadores por fecha
	public String mostrarGeneradoresFecha() {
		StringBuilder sb = new StringBuilder("Listado de generadores de la empresa "+ getNombre()+" ordenados por fecha: \n");
		
		//creo un arrayList del HashSet para poder implementar el sort
		List <AbstractGenerador> nueva = new ArrayList<AbstractGenerador>(generadores);
		//usando el compareTo
		Collections.sort(nueva);
		
		for(AbstractGenerador generador: nueva) {
			sb.append("\n\t> "+generador+"\n");
		}
		
		
		return sb.toString();
	}
	
	//mostrar generadores por localidad
	public String mostrarGeneradoresLocalidad() {
		StringBuilder sb = new StringBuilder("Listado de generadores de la empresa "+ getNombre()+" ordenados por localidad:  \n");
	
		//creo un arrayList del HashSet para poder implementar el sort
		List <AbstractGenerador> nueva = new ArrayList<AbstractGenerador>(generadores);
		//usando la interfaz comparator
		Collections.sort(nueva, new OrdenaLocalidad());
		
		for(AbstractGenerador generador: nueva) {
			sb.append("\n\t> "+generador+"\n");
		}
	
	
		return sb.toString();
	}
	
	
	//Deberá solicitar una localidad y mostrar si existe o no un generador en esa localidad.
	public String buscarGenerador(String localidad) {
		String mensaje = "";
		
		Iterator<AbstractGenerador> iterador = generadores.iterator();
		boolean esEncontrado = false;
		
		while(iterador.hasNext() && !esEncontrado) {
			AbstractGenerador ge = iterador.next();
			if(ge.localidad.equalsIgnoreCase(localidad)) {
				esEncontrado = true;
			}
		}
		
		if(!esEncontrado) {
			mensaje = "En su localidad no existe ningún generador";
		}else {
			mensaje = "En su localidad sí existe algún generador.";
		}
		
		return mensaje;
		
	}
	
	
	//mostrar la energia suministrada por la empresa
	//voy a entender que la energia suministrada es la potencia de cada generador
	public String mostrarEnergiaSuministrada() {
		
		double energia = 0;
		
		for(AbstractGenerador generador: generadores) {
			energia+= generador.getPotencia();
		}
		return "La energía total suministrada por la empresa es de: "+energia;
	}
	
	//Borrar generador (se deberán mostrar los generadores por el orden que quieras), solicitar
	//el código y eliminar el generador. Si no existe el generador se deberá mostrar el
	//correspondiente mensaje de error.
	
	public boolean borrarGenerador(String codigo) throws BorrarGeneradorExcepcion {
		
		Iterator<AbstractGenerador> iterador = generadores.iterator();
		boolean esBorrado = false;
		
		while(iterador.hasNext()&&!esBorrado) {
			AbstractGenerador ge = iterador.next(); //para que coja uno sobre el que hacer la comparacion
			if(ge.getCodigo().equalsIgnoreCase(codigo)) {
				generadores.remove(ge);
				esBorrado = true;
			}
		}
		if(esBorrado== false) {
			throw new BorrarGeneradorExcepcion();
		}
		
		
		return esBorrado;
		
	}


	public String getNombre() {
		return nombre;
	}

	
	
	
	
	
	
	

}
