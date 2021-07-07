package es.corona.model;

import java.time.LocalDate;

import es.corona.enume.Meses;


public class Corona {
	
	private LocalDate fecha;
	private int agno;
	private int contagios;
	private int curados;
	private int fallecidos;
	
	
	public Corona(LocalDate fecha, int agno, int contagios, int curados, int fallecidos) {
		super();
		this.fecha = fecha;
		this.agno = agno;
		this.contagios = contagios;
		this.curados = curados;
		this.fallecidos = fallecidos;
	}
	
	public Corona(String fecha,int agno, int contagios, int curados, int fallecidos) {
		super();
		this.fecha = convertirFormatoFecha(agno, fecha);
		this.agno = agno;
		this.contagios = contagios;
		this.curados = curados;
		this.fallecidos = fallecidos;
	}
	
	private LocalDate convertirFormatoFecha(int year, String fecha) { //"Día 27 de julio" dia>0 mes>3
		
		String aux[] = fecha.split(" ");
		int day = Integer.parseInt(aux[1]);
		int month = Meses.valueOf(aux[3].toUpperCase()).getNumero();
		
		LocalDate fechaNueva = LocalDate.of(year, month, day);
		
		return fechaNueva;
	}


	@Override
	public String toString() {
		return "Corona [fecha=" + fecha + ", agno=" + agno + ", contagios=" + contagios + ", curados=" + curados
				+ ", fallecidos=" + fallecidos + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		Corona other = (Corona) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getAgno() {
		return agno;
	}


	public void setAgno(int agno) {
		this.agno = agno;
	}


	public int getContagios() {
		return contagios;
	}


	public void setContagios(int contagios) {
		this.contagios = contagios;
	}


	public int getCurados() {
		return curados;
	}


	public void setCurados(int curados) {
		this.curados = curados;
	}


	public int getFallecidos() {
		return fallecidos;
	}


	public void setFallecidos(int fallecidos) {
		this.fallecidos = fallecidos;
	}
	
	

}
