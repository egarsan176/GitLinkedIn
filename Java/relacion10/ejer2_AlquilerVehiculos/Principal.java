package relac10.AvanzPOO.ejer2_AlquilerVehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import relac10.AvanzPOO.ejer2_AlquilerVehiculos.Furgoneta;
import relac10.AvanzPOO.ejer2_AlquilerVehiculos.GamaException;
import relac10.AvanzPOO.ejer2_AlquilerVehiculos.Coche;
import relac10.AvanzPOO.ejer2_AlquilerVehiculos.AbstractVehiculo;

public class Principal {

	public static void main(String[] args) {
		
		gui();

	}
	
	
	public static void mostrarMenu() {
		System.out.println("\nSeleccione una opción:\n"
				+ "1. Alta de vehículo\n"
				+ "2. Cálculo de precio de alquiler\n"
				+ "3. Salir\n");	}
	
	
	static Scanner teclado = new Scanner(System.in);
	static List<AbstractVehiculo> listaVehiculos = new ArrayList<AbstractVehiculo>(200);
	//no funciona así, el () es el constructor, para definir un tamaño, hacerlo con lenght e imcrementando hasta que llegue al tope y lanza una excepción
	static AbstractVehiculo vehiculo = null;
	
	public static void gui() {
		
		boolean finalizar = true;
		//AbstractVehiculo vehiculo = null;
		
		while(finalizar) {
			
			mostrarMenu();
			int opcion;
			opcion = Integer.parseInt(teclado.nextLine());
			
			
				switch (opcion) {
				case 1:
					
					System.out.println("¿Qué vehículo desea dar de alta? (C - coche || F - furgoneta || M - microbus)");
					String l = teclado.nextLine();
					listaVehiculos.add(darDeAlta(l));
					
					break;
				
				case 2:
					System.out.println("Introduzca el número de días que desea alquilar el vehículo: ");
					int dias = Integer.parseInt(teclado.nextLine());
					System.out.println("Introduzca la matrícula del vehículo que desea alquilar: ");
					String matricula = teclado.nextLine();
					
					try {
						System.out.println("El cálculo del alquiler del vehículo es de: "+calcularAlquiler(dias, matricula)+" euros.");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
					
				case 3:
					System.out.println("Ha salido del programa.");
					finalizar = false;
					
					break;
					
				default:
					break;
			
				}
				
			}
			
			teclado.close();
	}
	
	public static AbstractVehiculo darDeAlta(String letra) {
		//AbstractVehiculo vehiculo = null;
		
		while(!letra.equalsIgnoreCase("c") && !letra.equalsIgnoreCase("f") && !letra.equalsIgnoreCase("m")) {
			System.out.println("No disponemos del vehículo seleccionado..\n");
			System.out.println("¿Qué vehículo desea dar de alta? (C - coche || F - furgoneta || M - microbus");
			letra = teclado.nextLine();
		}
		
			//dar de alta un coche
		if(letra.equalsIgnoreCase("c")) {
			System.out.println("Para dar de alta un coche necesita introducir los siguientes datos:\n "+
					"matricula, gama seleccionada (BAJA, MEDIA, ALTA), combustible (GASOLINA, DIESEL).\n"
					+"(Presione INTRO tras introducir cada campo)");
			
			try {
				vehiculo = new Coche(teclado.nextLine(), teclado.nextLine(), teclado.nextLine());
				System.out.println("El coche ha sido dado de alta.");
			} catch (CombustibleException | GamaException e) {
				System.out.println(e.getMessage());
			}
			
		}
			//dar de alta una furgoneta
		if(letra.equalsIgnoreCase("f")) {
			System.out.println("Para dar de alta una furgoneta necesita introducir los siguientes datos:\n "+
					"matricula, gama seleccionada (BAJA, MEDIA, ALTA), PMA (peso máximo autorizado).\n"
					+"(Presione INTRO tras introducir cada campo)");
				
			try {
				vehiculo = new Furgoneta(teclado.nextLine(), teclado.nextLine(), Double.parseDouble(teclado.nextLine()));
				System.out.println("La furgoneta ha sido dado de alta.");
			} catch (GamaException e) {
				System.out.println(e.getMessage());
			}	
		}
			//dar de alta un microbus
		if(letra.equalsIgnoreCase("m")) {
			System.out.println("Para dar de alta un microbús necesita introducir los siguientes datos:\n "+
					"matricula, gama seleccionada (BAJA, MEDIA, ALTA), número de plazas.\n"
					+"(Presione INTRO tras introducir cada campo)");
			
			try {
				vehiculo = new Microbus(teclado.nextLine(), teclado.nextLine(), Integer.parseInt(teclado.nextLine()));
				System.out.println("El microbús ha sido dado de alta.");
			} catch (GamaException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
		return vehiculo;
	}
	
	public static double calcularAlquiler(int dias, String matricula) throws Exception {
		
		double precio =0;
		
		for(AbstractVehiculo vehiculo: listaVehiculos) {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
				precio = vehiculo.calcularAlquiler()*dias;
			}else {
				throw new Exception("La matrícula introducida no está dada de alta en el sistema.");
			}
		}
		
		return precio;
		
	}

}
