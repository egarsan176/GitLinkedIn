package com.municipios;

import java.io.IOException;
import java.util.Scanner;

import com.municipios.excep.ComunidadNotFoundException;
import com.municipios.excep.DescripcionNotFoundException;
import com.municipios.model.TamanoMunicipioComunidad;

public class Principal {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		//System.out.println(listado);

		gui();
	}

	public static TamanoMunicipioComunidad listado = new TamanoMunicipioComunidad();
	
	public static void mostrarMenu() {
		System.out.println("\nEscoja una opción: \n"
				+ "\t1. Mostrar los datos de todas las comunidades y de España de un año.\n"
				+ "\t2. Mostrar los datos de una comunidad y un año.\n"
				+ "\t3. Añadir un dato.\n"
				+ "\t4. Comprobar el valor total.\n"
				+ "\t5. Salir.\n");
	}
	
	public static void gui() throws IOException {
		boolean finalizar = true;
		
		while(finalizar) {
			
			mostrarMenu();
			int opcion;
			opcion = Integer.parseInt(teclado.nextLine());
			
			switch (opcion) {
			case 1:{
				int year = leerEntero("Escriba el año: ");
				System.out.println(listado.mostrarTodosLosDatos(year));
			}
				break;
				
			case 2:{
				String comunidad = leerCadena("Escriba el nombre de la comunidad: ");
				int year = leerEntero("Escriba el año: ");
				try {
					System.out.println(listado.mostrarDatosDeUnaComunidad(comunidad, year));
				} catch (ComunidadNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
				break;
				
			case 3:{
				String comunidad = leerCadena("Escriba el nombre de la comunidad: ");
				System.out.println("Descripciones Posibles: \n"
						+ "Total, Menos de 101, De 101 a 500, De 501 a 1.000, De 1.001 a 2.000, \n"
						+ "De 2.001 a 3.000, De 3.001 a 5.000, De 5.001 a 10.000, De 10.001 a 20.000, \n"
						+ "De 20.001 a 30.000, De 30.001 a 50.000, De 50.001 a 100.000, De 100.001 a 500.000, \n"
						+ "Más de 500.000");
				String descrip = leerCadena("Escriba la descripción (seleccione una opción de las de arriba): ");
				int year = leerEntero("Escriba el año: ");
				int valor = leerEntero("Escriba el valor del dato: ");
				
				try {
					listado.addDato(comunidad, descrip, year, valor);
				} catch (ComunidadNotFoundException | DescripcionNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
				break;
				
			case 4:{
				String comunidad= leerCadena("Escriba el nombre de la comunidad: ");
				int year = leerEntero("Escriba el año: ");
				System.out.println(listado.comprobarValorTotal(comunidad, year));
			}
				break;
				
				
			case 5:
				String guardar = leerCadena("¿Quiere guardar los datos en un nuevo fichero (S/N)?");
				
				if(guardar.equalsIgnoreCase("S")) {
					String fichero = leerCadena("Escriba el nombre del fichero: ");
					listado.crearNuevoFicheroJson(fichero);
					System.out.println("El fichero se ha creado satisfactoriamente.");
					finalizar = false;
				}else {
					finalizar = false;
				}
				
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
