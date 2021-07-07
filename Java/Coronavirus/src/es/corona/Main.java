package es.corona;

import java.util.Scanner;

import es.corona.model.ListaCoronavirus;

public class Main {

	public static void main(String[] args) {
		
		//System.out.println(lista);
		gui();
	}
	
	public static ListaCoronavirus lista = new ListaCoronavirus();

	private static Scanner teclado = new Scanner(System.in);
	
	public static void mostrarMenu() {
		System.out.println("\nEscoja una opción: \n"
				+ "\t1. Mejor día.\n"
				+ "\t2. Mejor día a partir de un día del mes.\n"
				+ "\t3. Peor día.\n"
				+ "\t4. Peor día a partir de un día del mes.\n"
				+ "\t5. Número de contagios, número de muertes y número de curados en un día.\n"
				+ "\t6. Media de contagios, de muertes y de curados.\n"
				+ "\t7. Salir.\n");
	}
	public static void gui() {
		boolean finalizar = true;
		
		while(finalizar) {
			
			mostrarMenu();
			int opcion;
			opcion = Integer.parseInt(teclado.nextLine());
			
			switch (opcion) {
			case 1:
				System.out.println(lista.mostrarMejorDia());
				break;
				
			case 2:
				int dia = leerEntero("Introduzca el día: ");
				String mes = leerCadena("Introduzca el mes: (en letras)");
				int anio = leerEntero("Introduzca el año: ");
				System.out.println(lista.mostrarMejorDiaDeFecha(dia, mes, anio));
				
				break;
				
			case 3:
				System.out.println(lista.mostrarPeorDia());
				
				break;
				
			case 4:
				int day = leerEntero("Introduzca el día: ");
				String month = leerCadena("Introduzca el mes: (en letras)");
				int year = leerEntero("Introduzca el año: ");
				System.out.println(lista.mostrarPeorDiaDeFecha(day, month, year));
				
				break;
				
			case 5:
				int dia1 = leerEntero("Introduzca el día: ");
				String mes1 = leerCadena("Introduzca el mes: (en letras)");
				int anio1 = leerEntero("Introduzca el año: ");
				System.out.println(lista.mostrarNumeroDeUnDia(dia1, mes1, anio1));
				
				break;
				
			case 6:
				System.out.println(lista.mostrarMedia());
				
				break;
				
			case 7:
				System.out.println("Ha salido del programa.");
				finalizar = false;
				break;

			default:
				break;
			}
			
		}
		teclado.close();
	}
	
	public static int leerEntero(String msg) {
		System.out.println(msg);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerCadena(String msg) {
		System.out.println(msg);
		return teclado.nextLine();
	}
	
}
