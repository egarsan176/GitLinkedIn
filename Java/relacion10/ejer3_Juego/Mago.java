package relac10.AvanzPOO.ejer3_Juego;

import java.util.Arrays;

import relac10.AvanzPOO.ejer3_Juego.Excep.FuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.InteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.MagoFuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.MagoInteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.PuntosVidaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.RazaException;

public class Mago extends AbstractPersonaje {
	
	private static final int INTELIGENCIA_MENOR_MAGO = 17;
	private static final int FUERZA_MAYOR_MAGO = 15;
	private String[] hechizos = new String[4];
	

	public Mago(String nombre, String raza, int fuerza, int inteligencia, int puntosVidaMax)
			throws RazaException, FuerzaException, InteligenciaException, PuntosVidaException, MagoInteligenciaException, MagoFuerzaException {
		super(nombre, raza, fuerza, inteligencia, puntosVidaMax);
		
		if(inteligencia<INTELIGENCIA_MENOR_MAGO) {
			throw new MagoInteligenciaException();
		}
		if(fuerza>FUERZA_MAYOR_MAGO) {
			throw new MagoFuerzaException();
			}
		this.hechizos = hechizos;
	}
	
	public void aprendeHechizo(String hechizoNuevo) {
	
		//compruebo cada posicion del vector
		if(this.hechizos[0] == null) {
			hechizos[0]= hechizoNuevo;
			
			System.out.println("¡Hechizo aprendido!\n");
		}
		else if(this.hechizos[1] == null) {
			hechizos[1]= hechizoNuevo;
			
			System.out.println("¡Hechizo aprendido!\n");
		}
		else if(this.hechizos[2] == null) {
			hechizos[2]= hechizoNuevo;
			
			System.out.println("¡Hechizo aprendido!\n");
		}
		else if(this.hechizos[3] == null) {
			hechizos[3]= hechizoNuevo;
			
			System.out.println("¡Hechizo aprendido!\n");
		}
	
		else if(hechizos[0] != null && hechizos[1] != null && hechizos[2] != null && hechizos[3] != null) {
			System.out.println("No queda espacio para aprender más hechizos.");
			
	}
		
	}
	
	
	
	public void lanzaHechizo(AbstractPersonaje p, String hechizo) {
		//si el personaje tiene menos de 10 puntos lo dejo a 0 con el set
		if((p.getPuntosVidaActual()-10)<=0) {
			p.setPuntosVidaActual(0);
		}else {
			//si tiene +10 puntos le resto 10
			p.setPuntosVidaActual(p.getPuntosVidaActual()-10);
		}
		
		for(int i=0; i<hechizos.length-1;i++) {
			//compruebo si el hechizo esta en el array
			if(hechizos[i]!= null && hechizos[i].equalsIgnoreCase(hechizo)) {
				//si lo encuentro lo pongo a null
				hechizos[i] = null;
				System.out.println("¡Has lanzado un hechizo contra "+p.getNombre()+"! Ya no dispones de este hechizo en tu memoria.");
			}
		}
	}
	
	
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + ", raza: " + getRaza() + ", fuerza: " + getFuerza() + ", inteligencia: "
				+ getInteligencia() + ", puntos de vida máximos: " + getPuntosVidaMax() + ", puntos de vida actual: " + getPuntosVidaActual() 
				+ " y su lista de hechizos es: "+Arrays.toString(hechizos)+".";
	}
	

	public String[] getHechizos() {
		return hechizos;
	}

	public void setHechizos(String[] hechizos) {
		this.hechizos = hechizos;
	}



	@Override
	public int compareTo(AbstractPersonaje p) {
		int result = 0;
		
		if(this.puntosVidaActual<(p.getPuntosVidaActual())) {
			result = 1;
		}else if(this.puntosVidaActual>(p.getPuntosVidaActual())) {
			result = -1;
		}
		return result;
	}
	
	

}
