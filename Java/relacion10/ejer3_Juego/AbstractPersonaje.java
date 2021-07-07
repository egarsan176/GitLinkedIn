package relac10.AvanzPOO.ejer3_Juego;

import relac10.AvanzPOO.ejer3_Juego.Excep.FuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.InteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.PuntosVidaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.RazaException;

public abstract class AbstractPersonaje implements Comparable<AbstractPersonaje>{
	
	private static final int MAXIMA_F_I = 20;
	protected static final int VIDA_MAXIMA = 100;
	private static final int VALOR_INICIO = 0;
	
	protected String nombre;
	protected String raza;
	protected int fuerza;
	protected int inteligencia;
	protected int puntosVidaMax;
	protected int puntosVidaActual;
	
	
	
	public AbstractPersonaje(String nombre, String raza, int fuerza, int inteligencia, int puntosVidaMax) throws RazaException, FuerzaException, InteligenciaException, PuntosVidaException {
		super();
		this.nombre = nombre;
		
		if(raza.equalsIgnoreCase("humano") || raza.equalsIgnoreCase("elfo") || raza.equalsIgnoreCase("enano") || raza.equalsIgnoreCase("orco")) {
			this.raza = raza;
		}else {
			throw new RazaException();
		}
		
		if(fuerza<VALOR_INICIO && fuerza>MAXIMA_F_I) {
			throw new FuerzaException();
		}else {
			this.fuerza = fuerza;
		}
		
		if(inteligencia<VALOR_INICIO && inteligencia>MAXIMA_F_I) {
			throw new InteligenciaException();
		}else {
			this.inteligencia = inteligencia;
		}
		
		if(puntosVidaMax<VALOR_INICIO && puntosVidaMax>VIDA_MAXIMA) {
			throw new PuntosVidaException();
		}else {
			this.puntosVidaMax = puntosVidaMax;
			this.puntosVidaActual = puntosVidaMax;
		}
		
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getPuntosVidaMax() {
		return puntosVidaMax;
	}

	public void setPuntosVidaMax(int puntosVidaMax) {
		this.puntosVidaMax = puntosVidaMax;
	}

	public int getPuntosVidaActual() {
		return puntosVidaActual;
	}

	public void setPuntosVidaActual(int puntosVidaActual) {
		this.puntosVidaActual = puntosVidaActual;
	}

	@Override
	public String toString() {
		return "Nombre: " + getNombre() + ", raza: " + getRaza() + ", fuerza: " + getFuerza() + ", inteligencia: "
				+ getInteligencia() + ", puntos de vida máximos: " + getPuntosVidaMax() + ", puntos de vida actual: " + getPuntosVidaActual() + ".";
	}



	public int compareTo(AbstractPersonaje o) {
		
		return 0;
	}
	
	
	
	
	

}
