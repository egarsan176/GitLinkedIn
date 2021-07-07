/**
 * Al crear una cuenta de crédito se indica de qué cantidad de
crédito se dispone, es decir, a cuánto puede quedar la cuenta en
números rojos. Por ejemplo, si el crédito es de 100€ la cuenta
podrá llegar a tener un saldo igual a –100.
• Inicialmente, si no se indica nada, el saldo de la cuenta es 0€.
• Inicialmente, si no se indica nada, el crédito es de 100€.
• Se deben incluir los métodos get y set para el crédito. El crédito
nunca puede superar los 300€. También habrá que tener en
cuenta el saldo actual de la cuenta.
• Se deberá modificar los métodos de sacarDinero para incluir el
crédito.
 */

package relac10.AvanzPOO.ejer1_CuentaCredito;

import ejeHERENCIA.ejer1.Titular;
import poo.ej2.Cuenta.Cuenta;

public class CuentaCredito extends Cuenta {
	
	private double credito;
	
	private static final double CANTIDAD_INICIAL_CREDITO = 100;
	private static final double CANTIDAD_MAXIMA_CREDITO = 300;
	
	//constructor sin parametros con saldo inicial 0 y credito de 100
	public CuentaCredito() {
		super();
		this.credito = CANTIDAD_INICIAL_CREDITO;
	}
	//constructor con parametros saldo y titular y credito=saldo de la cuenta y <300
	public CuentaCredito(double saldo, Titular titular) {
		super(saldo, titular);
		if(saldo>=CANTIDAD_MAXIMA_CREDITO) {
			this.credito = CANTIDAD_MAXIMA_CREDITO;
		}else {
			this.credito = saldo;
		}
	}
	//constructor con parametros saldo, titular y credito
	public CuentaCredito(double saldo, Titular titular, double credito) {
		super(saldo, titular);
		if(this.credito<CANTIDAD_MAXIMA_CREDITO) {
			this.credito = credito;
		}
	}
	
	@Override
	public void hacerReintegro(double reintegro) throws Exception {
		
		if(saldo>0 && saldo>=reintegro && reintegro>0) {
			saldo-=reintegro;
			numeroReintegros++;
			
			
		}else if (saldo <= 0.0 && reintegro<=credito && credito>0){
			credito-=reintegro;
			saldo-=reintegro;
			numeroReintegros++;
			
			
		}else if(saldo<reintegro && reintegro <= (saldo+credito)) {
			double a = saldo;
			if(reintegro <= (saldo+credito)) {
				saldo -= reintegro;
				credito-=(reintegro-a);

				numeroReintegros++;
			}
		}
		else {
			throw new Exception("La operación no se puede realizar");
		}
	}

	
	
	@Override
	public void hacerIngreso(double ingreso) throws Exception {
		
		if(saldo<=0) {
			saldo+=ingreso;
			numeroIngresos++;
		}else {
			super.hacerIngreso(ingreso);
		}
				
		}
		

	
	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}
	

	@Override
	public String getStatus() {
		
		return "El saldo es "+ this.saldo
				+ " y el crédito es " + credito;
	}
	
	
	
}
