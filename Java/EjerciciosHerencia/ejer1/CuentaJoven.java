/**
 * /**
 * A partir de la clase cuenta vamos a definir ahora una “Cuenta Joven”, para ello vamos a crear una
nueva clase CuantaJoven que deriva de la anterior. Cuando se crea esta nueva clase, además del
titular y la cantidad se debe guardar una bonificación que estará expresada en tanto por ciento.
Construye los siguientes métodos para la clase:
•Un constructor.
•Los setters y getters para el nuevo atributo.
•En esta ocasión los titulares de este tipo de cuenta tienen que ser mayor de edad., por lo
tanto hay que crear un método esTitularValido() que devuelve verdadero si el titular es
mayor de edad pero menor de 25 años y falso en caso contrario.
•Además la retirada de dinero sólo se podrá hacer si el titular es válido.
•El método mostrar() debe devolver el mensaje de “Cuenta Joven” y la bonificación de la
cuenta.
Piensa los métodos heredados de la clase madre que hay que reescribir.
 */


package ejeHERENCIA.ejer1;

import poo.ej2.Cuenta.Cuenta;

public class CuentaJoven extends Cuenta{
	
	private Bonificacion bonificacion = Bonificacion.CUENTA_JOVEN;
	
	public CuentaJoven() {
		super();
	}

	public CuentaJoven(double saldo, Titular titular) {
		super(saldo, titular);
		if(esTitularValido()) {
			this.titular = titular;
		}
		this.bonificacion = Bonificacion.CUENTA_JOVEN;
		
	}

	public boolean esTitularValido() {
		boolean esValido = false;
		if(this.getTitular().getEdad()>=18 && this.getTitular().getEdad()<=25) {
			esValido = true;
		}
	
		return esValido;
	}
	
	@Override
	public void hacerReintegro(double reintegro) throws Exception {
		if(esTitularValido()) {
			super.hacerReintegro(reintegro);
		}else {
			throw new Exception ("Este titular no puede retirar dinero de esta cuenta.");
		}
		
	}
	

	@Override
	public String toString() {
		return "Cuenta Joven: tiene un " + Bonificacion.CUENTA_JOVEN.getBonificacion() + "% de bonificación.";
	}
	
	
	public Bonificacion getBonificacion() {
		return bonificacion;
	}

	
	

	
	
	

	
	

	

	

	
	
	
	
	
	

}
