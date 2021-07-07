package relac10.AvanzPOO.ejer5_Instalacion;

public class Polideportivo implements IEdificio, IInstalacionDeportiva {

	private int tipoInstalacion;
	private double superficie;
	private String nombre;
	
	public Polideportivo(int tipoInstalacion, double superficie, String nombre) {
		this.tipoInstalacion = tipoInstalacion;
		this.superficie = superficie;
		this.nombre = nombre;
	}
	
	@Override
	public int getTipoDeInstalacion() {
		
		return tipoInstalacion;
	}

	@Override
	public double getSuperficieEdificio() {
		
		return superficie;
	}
	
	

	@Override
	public String toString() {
		return "El polideportivo "+ getNombre() +", es de tipo " + getTipoDeInstalacion() + " y tiene una superficie de " 
				+ getSuperficieEdificio() + " m2.";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
	
	

}
