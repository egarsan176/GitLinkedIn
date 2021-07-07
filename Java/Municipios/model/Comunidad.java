package com.municipios.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Comunidad {
	private String nombre;
	private List<Municipio> listMunicipio;
	

	
	public Comunidad(String descrip) {
		
		this.nombre = descrip;
		this.listMunicipio = new ArrayList<Municipio>();
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comunidad other = (Comunidad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<Municipio> getMunicipio() {
		return listMunicipio;
	}



	public void setMunicipio(List<Municipio> listMunicipio) {
		this.listMunicipio = listMunicipio;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\n"+nombre+":\n");
		
		for (Municipio municipio : listMunicipio) {
			sb.append("\t"+municipio+"\n");
		}
		
		return sb.toString();
	}
	
	
	public String getDatoAnno(int ano) {
		StringBuilder sb = new StringBuilder();
		for (Municipio m : listMunicipio) {
			sb.append(m.devuelveDatoLista(ano));
		}
		return sb.toString();
	}

	public void addDato(int ano, int valor, String descr) {
		try {
			Municipio m = this.listMunicipio.get(this.listMunicipio.indexOf(new Municipio(descr)));
			m.devuelveListaLocalidad(ano, valor);
		} catch (Exception e) {
			System.out.println("No existe el municipio");
		}

	}

	public int compruebaTotal(int ano) {
		int total = 0;
		for (Municipio m : listMunicipio) {
			if (!m.getDescrip().equals("Total")) {
				total += m.compruebaTotal(ano);
			}
		}
		return total;
	}

	public int consigueDatoTotal(int ano) {
		int total = 0;
		boolean resul = false;
		Iterator<Municipio>m= this.listMunicipio.iterator();
		
		while(m.hasNext() && !resul) {
			Municipio mu = m.next();
			if(mu.getDescrip().equals("Total")) {
				total = mu.compruebaTotal(ano);
			}
		}
		return total;
	}
	
	
	

	
}