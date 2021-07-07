/**
 * En un puerto se alquilan amarres para barcos de distinto tipo. Para cada ALQUILER se guarda el
nombre y DNI del cliente, las fechas inicial y final de alquiler, la posición del amarre y el barco que
lo ocupará.
Un BARCO se caracteriza por su matrícula, su eslora en metros y año de fabricación. Un alquiler se
calcula multiplicando el número de días de ocupación (incluyendo los días inicial y final) por el
precio que cobraremos a cada barco (obtenido simplemente multiplicando por 10 los metros de
eslora) y por un valor fijo (20 euros en la actualidad).
Sin embargo ahora se pretende diferenciar la información de algunos tipos de barcos: número de
mástiles para veleros, potencia en CV para embarcaciones deportivas a motor y potencia en CV y
número de camarotes para yates de lujo. El precio de los barcos de un tipo especial se obtiene como
el precio normal mas: el número de mástiles para veleros, la potencia en CV para embarcaciones
deportivas a motor y la potencia en CV más el número de camarotes para yates de lujo.
Utilizando la herencia crea un programa que permita introducir y crear alquileres para distintos
barcos.
 */

package ejeHERENCIA.ejer2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler {

	private Cliente cli;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	private int posicionAmarre;
	private Embarcacion barco;
	
	
	public Alquiler() {
		super();
	}
	

	public Alquiler(Cliente cli, LocalDate fechaIni, LocalDate fechaFin, int posicionAmarre, Embarcacion barco) {
		super();
		this.cli = cli;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.posicionAmarre = posicionAmarre;
		this.barco = barco;
	}
	
	public double calcularPrecioAlquiler() {
		
		//long dias = ChronoUnit.DAYS.between(fechaIni, fechaFin);
		
		return (ChronoUnit.DAYS.between(fechaIni, fechaFin)+1) * (this.barco.calcularAlquiler());
		//+1 porque no incluye el de la fecha fin
		
	}
	
	
	
}
