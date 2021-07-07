package repasoExamenes.exCOLLECTION;

import java.time.LocalDate;
import java.util.Scanner;

import repasoExamenes.exCOLLECTION.excep.AddGeneradorException;
import repasoExamenes.exCOLLECTION.excep.BorrarGeneradorExcepcion;
import repasoExamenes.exCOLLECTION.excep.ETipoException;
import repasoExamenes.exCOLLECTION.excep.FechaException;
import repasoExamenes.exCOLLECTION.model.ETipoGeneradorSolar;
import repasoExamenes.exCOLLECTION.model.Empresa;
import repasoExamenes.exCOLLECTION.model.Eolico;
import repasoExamenes.exCOLLECTION.model.Solar;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args){
		
		Empresa empresa = new Empresa("Empresilla S.L.");
		int opc;
		do {
			menu();
			opc = leerEntero("Introduzca la opción deseada");
			switch (opc) {
			case 1:
				System.out.println("Nuevo Generador Solar.\nIntroduzca los siguientes datos: \n");
				
				String localidad = leerCadena("Introduzca la localidad: ");
				double potencia = leerReal("Introduzca la potencia: ");
				int paneles = leerEntero("Introduzca el número de paneles: ");
				double metros = leerReal("Introduzca los metros cuadrados de paneles: ");
				String tipo = leerCadena("Introduzca el tipo de generador: (FOTOVOLTAICO-TERMICO-HIBRIDO) ").toUpperCase();
				LocalDate fecha = obtenerFecha();
				ETipoGeneradorSolar tp;
				
				try {
					if(tipo.equals(ETipoGeneradorSolar.values())) {
						tp = ETipoGeneradorSolar.valueOf(tipo);
						
					}else {
						throw new ETipoException();
					}
					if(fecha.isAfter(LocalDate.now())){
						throw new FechaException();
					}
					Solar genSolar = new Solar(localidad, potencia, fecha, paneles, metros, tp);
					empresa.addGenerador(genSolar);
					System.out.println("Se ha añadido el generador");
							
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
				
			case 2:
				System.out.println("Nuevo Generador Eólico.\nIntroduzca los siguientes datos: \n");
				
				String loc = leerCadena("Introduzca la localidad: ");
				double pot = leerReal("Introduzca la potencia: ");
				int aspas = leerEntero("Introduzca el número de aspas: ");
				LocalDate fecha2 = obtenerFecha();
				
				
				
				try {
					if(fecha2.isAfter(LocalDate.now())){
					throw new FechaException();
				}
					Eolico genEolico = new Eolico(loc, pot, fecha2, aspas);
					empresa.addGenerador(genEolico);
					System.out.println("Se ha añadido el generador");
				} catch (AddGeneradorException | FechaException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				System.out.println(empresa.mostrarGeneradoresFecha());
				break;
			case 4:
				System.out.println(empresa.mostrarGeneradoresLocalidad());
				break;
			case 5:
				System.out.println(empresa.mostrarGeneradoresEolicos());
				break;
			case 6:
				System.out.println("\nEscoja de la siguiente lista el código del generador a borrar: ");
				System.out.println(empresa.mostrarGeneradoresFecha());
				
				String cod = leerCadena("\nIntroduzca el código seleccionado: ");
				try {
					System.out.println(empresa.borrarGenerador(cod));
				} catch (BorrarGeneradorExcepcion e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				System.out.println(empresa.mostrarEnergiaSuministrada());
				break;
			case 8:
				String local = leerCadena("Introduzca la localidad en la que desea comprobar la existencia de generadores: \n");
				System.out.println(empresa.buscarGenerador(local));
				
				break;
			case 9:
				System.out.println("Ha salido del programa.");
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
			
		}while (opc !=9);
	}
	
	public static void menu() {
		System.out.println("\n1.-Añadir generador solar\n"+
							"2.-Añadir generador eólico\n"+
							"3.-Mostrar generadores por fecha\n"+
							"4.-Mostrar generadores por localidad\n"+
							"5.-Mostrar generadores eólicos\n"+
							"6.-Borrar generador\n"+
							"7.-Total energía\n"+
							"8.-¿Existe generador en Localidad? \n"+
							"9.-Salir\n"
				);
	}
	
	public static int leerEntero(String msg) {
		System.out.println(msg);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerCadena(String msg) {
		System.out.println(msg);
		return teclado.nextLine();
	}
	
	public static double leerReal(String msg) {
		System.out.println(msg);
		return Double.parseDouble(teclado.nextLine());
	}
	
	public static LocalDate obtenerFecha() {
		
		System.out.println("Introduzca el día de la fecha: ");
		int day = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca el mes de la fecha: ");
		int month = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca el año de la fecha: ");
		int year = Integer.parseInt(teclado.nextLine());
		
		
		return LocalDate.of(year, month, day);
	}

}
