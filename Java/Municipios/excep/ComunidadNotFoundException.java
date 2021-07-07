package com.municipios.excep;

public class ComunidadNotFoundException extends Exception {
	public ComunidadNotFoundException() {
		super("La comunidad seleccionada no existe.");
	}
}
