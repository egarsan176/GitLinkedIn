package es.corona.model;

import java.util.ArrayList;
import java.util.List;

public class Datos {
	
	private  List<Metrica> Metricas;
	
	public Datos() {
		super();
		this.Metricas = new ArrayList<Metrica>();
	}
	
	public Datos(ArrayList<Metrica> metrica) {
		super();
		this.Metricas = metrica;
	}

	public List<Metrica> getMetricas() {
		return Metricas;
	}
	
	

}
