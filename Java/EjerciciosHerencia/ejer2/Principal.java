package ejeHERENCIA.ejer2;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {

		Embarcacion v = new Velero("2854LK", 18.5, 2000, 2);

		Yate y = new Yate("1425PL", 21.2, 2012, 300, 3);
		
		Embarcacion d = new Deportiva("1147KJ", 11.5, 2019, 200);

		System.out.println(v.getMatricula());
		System.out.println(y.getPotencia());
		System.out.println(d.calcularAlquiler());
		
		Cliente cli = new Cliente("Pepita", "2514875Z");
		
		LocalDate f1 = LocalDate.parse("2020-03-10");
		LocalDate f2 = LocalDate.parse("2020-03-21");
		
		
		Alquiler a = new Alquiler(cli, f1, f2, 201, v);
		System.out.println("El precio del alquiler es de "+a.calcularPrecioAlquiler()+" euros.");

	}

}
