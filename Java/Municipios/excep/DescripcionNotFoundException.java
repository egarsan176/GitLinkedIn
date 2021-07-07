package com.municipios.excep;

public class DescripcionNotFoundException extends Exception {
	public DescripcionNotFoundException() {
		super("La descripción introducida no corresponde con ninguna de las posibles opciones.");
	}
}
