package repasoExamenes.exCOLLECTION.model;


import java.time.LocalDate;

public abstract class AbstractGenerador implements IMonetizable, Comparable<AbstractGenerador>{
	
	protected static int CONTADOR_GENERADORES = 0;
	
	protected String codigo;
	protected LocalDate fecha;
	protected String localidad;
	protected double potencia;

	public AbstractGenerador(String localidad, double potencia, LocalDate fecha) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.localidad = localidad;
		this.potencia = potencia;
		
	}
	

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public String getCodigo() {
		return codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getLocalidad() {
		return localidad;
	}

	@Override
	public String toString() {
		return "Generador con código: " + getCodigo() + 
				"\nFecha comienzo de funcionamiento: " + getFecha()+ 
				".\nLocalidad: " + getLocalidad() +
				".\nPotencia: " + getPotencia() + ".";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
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
		AbstractGenerador other = (AbstractGenerador) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		return true;
	}

	@Override
	public int compareTo(AbstractGenerador g) {
		int compareResult = 0;
		
		if(this.fecha.isAfter(g.getFecha())) {
			compareResult = 1;
		}else if(this.fecha.isBefore(g.getFecha())) {
			compareResult = -1;
		}
		
		return compareResult;
	}

	
	
	
	
	
	
}
