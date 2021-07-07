package es.corona.model;

import java.util.ArrayList;

public class Metrica {

	private ArrayList<Informacion> Datos;

	public Metrica() {
		this.Datos = new ArrayList<Informacion>();
	}

	
	public Metrica(ArrayList<Informacion> datos) {
		super();
		Datos = datos;
	}


	public ArrayList<Informacion> getInformacion() {
		return Datos;
	}
}
