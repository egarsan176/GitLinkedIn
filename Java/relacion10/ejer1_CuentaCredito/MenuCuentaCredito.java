package relac10.AvanzPOO.ejer1_CuentaCredito;

import java.util.Scanner;

import ejeHERENCIA.ejer1.Titular;

public class MenuCuentaCredito {
	
	
	
	public static final String MENU = "\nElija una opción: \n"
			+ "1. Ingresar dinero\n" + 
			"2. Sacar dinero\n" + 
			"3. Mostrar saldo y crédito\n" + 
			"4. Salir\n";
	
	
	public static void mostrarMenu() {
		System.out.println(MENU);
	}
	
	public static void gui(CuentaCredito c) {
		
		Scanner teclado = new Scanner(System.in);
		
		
		int opcion = 0;
		boolean finalizar = true;
		while(finalizar) {
			
		mostrarMenu();
		opcion = Integer.parseInt(teclado.nextLine());
			
			
				switch (opcion) {
				case 1:
					try {
						System.out.println("¿Qué cantidad quiere ingresar?");
						double cantidadIngresar = Double.parseDouble(teclado.nextLine());
						c.hacerIngreso(cantidadIngresar);
						System.out.println("Ingreso realizado correctamente");
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				
				case 2:
					try {
						System.out.println("¿Qué cantidad quiere retirar?");
						double cantidadARetirar = Double.parseDouble(teclado.nextLine());
						c.hacerReintegro(cantidadARetirar);
						System.out.println("Reintegro realizado correctamente");
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					System.out.println(c.getStatus());
					
				default:
					break;
					
				case 4:
					System.out.println("Ha salido del programa.");
					finalizar = true;
				}
				
			}
			
			teclado.close();
			
		
	}

}
