package com.municipios.model;

import java.util.ArrayList;
import java.util.List;

public class Municipio {

	private String  descrip;
	private List<Datos> datos;
	
	
	public Municipio() {
		super();
		this.descrip = descrip;
		this.datos = new ArrayList<Datos>();
	}
	
	public Municipio(String descrip) {
		this.descrip = descrip;
		this.datos = new ArrayList<Datos>();
	}


	public String getDescrip() {
		return descrip;
	}


	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}


	public List<Datos> getDatos() {
		return datos;
	}


	public void setDatos(List<Datos> datos) {
		this.datos = datos;
	}


	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("\n"+descrip+":\n");
		
		for (Datos datos2 : datos) {
			sb.append("\t"+datos2+"\n");
		}
		return sb.toString();
	}
	
	
	
	public String devuelveDatoLista(int ano) {
		StringBuilder sb = new StringBuilder();
		boolean resul = false;

		for (Datos datos2 : datos) {
			if (datos2.getAno() == ano && !resul) {
				sb.append(datos2 + "\n");
				resul = true;
			}
		}
		return sb.toString();
	}

	public void devuelveListaLocalidad(int ano, int valor) {
		try {
			Datos d = this.datos.get(this.datos.indexOf(new Datos(ano, valor)));

			if (d.getAno() == ano) {
				d.setDato(valor);
			} else {
				Datos da = new Datos(ano, valor);
				this.datos.add(da);
			}

		} catch (Exception e) {
			System.out.println("");
		}
	}

	public int compruebaTotal(int ano) {
		Datos d = this.datos.get(this.datos.indexOf(new Datos(ano)));// el equal de Datos es por año solo

		return d.getDato();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
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
		Municipio other = (Municipio) obj;
		if (descrip == null) {
			if (other.descrip != null)
				return false;
		} else if (!descrip.equals(other.descrip))
			return false;
		return true;
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}