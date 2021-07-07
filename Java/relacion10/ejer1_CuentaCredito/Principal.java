package relac10.AvanzPOO.ejer1_CuentaCredito;

import ejeHERENCIA.ejer1.Titular;

public class Principal {

	public static void main(String[] args) {
		
		Titular t = new Titular();
		
		CuentaCredito c = new CuentaCredito(200, t);
		
		MenuCuentaCredito  m = new MenuCuentaCredito();
		
		m.gui(c);
	}

}
