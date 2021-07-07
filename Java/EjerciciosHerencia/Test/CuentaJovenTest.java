package ejeHERENCIA.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ejeHERENCIA.ejer1.CuentaJoven;
import ejeHERENCIA.ejer1.Titular;

class CuentaJovenTest {
	
	CuentaJoven c = new CuentaJoven();
	
	@Test
	void testEsTitularValido() {
		
		Titular correcto = new Titular("Pepa", 18);
		c.setTitular(correcto);
		assert(c.esTitularValido());
	}
	

	@Test 
	public void noEsTitularValidoParaCuentaJoven(){
				
		Titular menorEdad = new Titular("E", 15);
		c.setTitular(menorEdad);
		assertFalse(c.esTitularValido());
		
		Titular mayor25 = new Titular("F", 26);
		c.setTitular(mayor25);
		assertFalse(c.esTitularValido());
		
	}
	
	@Test
	public void lanzarExcepcionCuandoNoExisteTitular() {
		boolean lanzaExcepcion = false;
		
		try {
			CuentaJoven cu = new CuentaJoven();
			cu.esTitularValido();
		}catch(NullPointerException e) {
			lanzaExcepcion = true;
		}
		assert(lanzaExcepcion);
		
	}
	
	
	
	@Test 
	public void noReintegrosSiTitularNoValido() {
		
		Titular menorEdad = new Titular("E", 15);
		CuentaJoven cj = new CuentaJoven(500, menorEdad);
		
		try {
			cj.hacerReintegro(50);
		} catch (Exception e) {
			assert(true);
		}
	}
	
	@Test 
	public void reintegrosSiTitularNoValido() {
		
		Titular correcto = new Titular("Pepa", 18);
		CuentaJoven cj = new CuentaJoven(500, correcto);
		
		cj.setTitular(correcto);
		
		try {
			cj.hacerReintegro(50);
		}catch (Exception e){
			assert(false);
		}
		
		
	}
	
	

	
	

	

}
