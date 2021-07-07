package relac10.AvanzPOO.ejer3_Juego;

import relac10.AvanzPOO.ejer3_Juego.Excep.ClerigoFuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.ClerigoInteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.FuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.InteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.PuntosVidaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.RazaException;

public class Clerigo extends AbstractPersonaje {
	
	private static final int INTELIGENCIA_MENOR_CLERIGO = 12;
	private static final int INTELIGENCIA_MAYOR_CLERIGO = 16;
	private static final int FUERZA_MENOR_CLERIGO = 18;
	
	private String dios;

	public Clerigo(String nombre, String raza, int fuerza, int inteligencia, int puntosVidaMax, String dios)
			throws RazaException, FuerzaException, InteligenciaException, PuntosVidaException, ClerigoFuerzaException, ClerigoInteligenciaException {
		super(nombre, raza, fuerza, inteligencia, puntosVidaMax);
		this.dios = dios;
		
		if(fuerza<FUERZA_MENOR_CLERIGO) {
			throw new ClerigoFuerzaException();
		}
		if(inteligencia<=INTELIGENCIA_MENOR_CLERIGO || inteligencia>=INTELIGENCIA_MAYOR_CLERIGO) {
			throw new ClerigoInteligenciaException();
		}
	}

	public void curar(AbstractPersonaje p) {
		//compruebo si su vida actual+10 superaria la maxima
		if(p.getPuntosVidaActual()+10 >= 100) {
			p.setPuntosVidaActual(VIDA_MAXIMA);
		}else {
			p.setPuntosVidaActual(p.getPuntosVidaActual()+10);
		}
		
	}
	
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + ", raza: " + getRaza() + ", fuerza: " + getFuerza() + ", inteligencia: "
				+ getInteligencia() + ", puntos de vida máximos: " + getPuntosVidaMax() + ", puntos de vida actual: " + getPuntosVidaActual() 
				+ " y su Dios es: "+getDios()+".";
	}
	
	
	public String getDios() {
		return dios;
	}

	public void setDios(String dios) {
		this.dios = dios;
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
