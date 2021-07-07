package ejeHERENCIA.ejer1;

public class Principal {

	public static void main(String[] args) {
		
		Titular Pepa = new Titular("Pepa Flores", 22);
		
		CuentaJoven c = new CuentaJoven(1000, Pepa);
		
		System.out.println(c.esTitularValido());
		System.out.println(c.toString());
		
		try {
			c.hacerReintegro(20);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		

	}

}
