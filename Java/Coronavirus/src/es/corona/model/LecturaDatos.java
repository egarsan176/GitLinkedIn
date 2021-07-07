package es.corona.model;

public class LecturaDatos {
	
	private Datos Datos; //es el objeto que inicia el json, que dentro tiene al objeto Datos

	public LecturaDatos(es.corona.model.Datos datos) {
		super();
		Datos = datos;
	}


	public Datos getDatos() {
		return Datos;
	}


	public void setDatos(Datos datos) {
		Datos = datos;
	}
	
	
	
	
}
