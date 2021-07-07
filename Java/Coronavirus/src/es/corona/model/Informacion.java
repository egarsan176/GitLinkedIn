package es.corona.model;

public class Informacion {

	private int Agno;
	private String Periodo;
	private long Valor;
	
	
	public Informacion(int agno, String periodo, long valor) {
		super();
		this.Agno = agno;
		this.Periodo = periodo;
		this.Valor = valor;
	}


	public int getAgno() {
		return Agno;
	}


	public String getPeriodo() {
		return Periodo;
	}


	public long getValor() {
		return Valor;
	}


	@Override
	public String toString() {
		return "Informacion [Agno=" + Agno + ", Periodo=" + Periodo + ", Valor=" + Valor + "]";
	}
	
	
	
}
