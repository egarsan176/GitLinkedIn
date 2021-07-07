package relac10.AvanzPOO.ejer3_Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import relac10.AvanzPOO.ejer3_Juego.Excep.ClerigoFuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.ClerigoInteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.FuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.InteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.MagoFuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.MagoInteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.PuntosVidaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.RazaException;

public class MainMenu implements CreableEstadisticas{

	public static void main(String[] args) {
		
		//GUI();
		try {
			Mago A = new Mago("Gandalf", "elfo", 10, 19, 80);
			listaPersonajes.add(A);
		} catch (RazaException | FuerzaException | InteligenciaException | PuntosVidaException
				| MagoInteligenciaException | MagoFuerzaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Mago B = new Mago("Sauron", "enano", 9, 17,90);
			listaPersonajes.add(B);
		} catch (RazaException | FuerzaException | InteligenciaException | PuntosVidaException
				| MagoInteligenciaException | MagoFuerzaException e) {
			System.out.println(e.getMessage());
		}
		try {
			Clerigo C = new Clerigo("Frodo", "humano", 19, 15, 100, "Odin" );
			listaPersonajes.add(C);
		} catch (RazaException | FuerzaException | InteligenciaException | PuntosVidaException | ClerigoFuerzaException
				| ClerigoInteligenciaException e) {
			System.out.println(e.getMessage());
		}
		
	
	
	}
	
	public static void mostrarMenu() {
		System.out.println("\nSeleccione una opción:\n"
				+ "1. Alta de personaje.\n"
				+ "2. Mago aprende hechizo.\n"
				+ "3. Mago lanza hechizo.\n"
				+ "4. Clérigo cura al Mago.\n"
				+ "5. Mostrar el listado de personajes.\n"
				+ "6. Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor.\n"
				+ "7. Salir.\n");
	}
	
	static Scanner  teclado = new Scanner (System.in);
	static List<AbstractPersonaje> listaPersonajes = new ArrayList<AbstractPersonaje>(100);
	
	public static void GUI() {
		
		boolean a = true;
		
		while(a) {
			
			mostrarMenu();
			int opcion;
			opcion = Integer.parseInt(teclado.nextLine());
			
			switch (opcion) {
			case 1:
				System.out.println("\nIndique el personaje que desea crear: (M - Mago || C - Clérigo)");
				String letra = teclado.nextLine();
				listaPersonajes.add(seleccionarPersonaje(letra));
				
				break;
				
			case 2:
				System.out.println("\nEscriba el nombre del Mago:\n");
				String nombre = teclado.nextLine();
				System.out.println("\nEscriba el hechizo que desea aprender: \n");
				String hechizo = teclado.nextLine();
				for (AbstractPersonaje personaje: listaPersonajes) {
					if(personaje instanceof Mago && personaje.getNombre().equalsIgnoreCase(nombre)) {
						((Mago) personaje).aprendeHechizo(hechizo);
						//System.out.println(personaje);
					}
				}
				
				break;
				
			case 3:
				System.out.println("\nEscriba el nombre del Mago que va a lanzar el hechizo:\n");
				String n1 = teclado.nextLine();
				System.out.println("\n¿A quién quiere lanzarle un hechizo?\n");
				String n2 = teclado.nextLine();
				
				
				for (AbstractPersonaje personaje: listaPersonajes) {
					if(personaje instanceof Mago && personaje.getNombre().equalsIgnoreCase(n1)){
						System.out.println("Su lista contiene los siguientes hechizos:\n"+((Mago)personaje).getHechizos().toString());
					}
				}
				
				System.out.println("\n¿Qué hechizo quiere lanzar?:\n");
				String hechizoLanza = teclado.nextLine();
				
				
				for (AbstractPersonaje personaje: listaPersonajes) {
					for(AbstractPersonaje recibeHechizo: listaPersonajes) {
						if((personaje instanceof Mago && personaje.getNombre().equalsIgnoreCase(n1) && ((Mago)personaje).getHechizos()!=null)
								&& recibeHechizo.getNombre().equalsIgnoreCase(n2)) {
							((Mago) personaje).lanzaHechizo(recibeHechizo, hechizoLanza);
					}else {
						
					}
				}
				}
				
				break;
				
			case 4:
				System.out.println("\nEscriba el nombre del clérigo:\n");
				String clerigo = teclado.nextLine();
				System.out.println("\nEscriba el nombre del Mago que desea curar:\n");
				String mago = teclado.nextLine();
				
				for (AbstractPersonaje personaje: listaPersonajes) {
					for(AbstractPersonaje m: listaPersonajes) {
						if((personaje instanceof Clerigo && personaje.getNombre().equalsIgnoreCase(clerigo))
								&& m.getNombre().equalsIgnoreCase(mago)) {
							((Clerigo)personaje).curar(m);
							System.out.println(m.getNombre()+" ha sido curado.");
						}
					}
				}
				
				break;
				
			case 5:
				for(AbstractPersonaje personaje: listaPersonajes) {
					System.out.println(personaje+"\n");
				}
				break;
				
			case 6:
				Collections.sort(listaPersonajes);
				for(AbstractPersonaje personaje: listaPersonajes) {
					System.out.println(personaje+"\n");
				}
				break;
			
			case 7:
				System.out.println("Ha salido del juego.");
				a = false;
	
			default:
				break;
			}
		}
				
				
			
	}
			
		
	
	public static AbstractPersonaje seleccionarPersonaje(String letra) {
		AbstractPersonaje  p = null;
		
		while(!letra.equalsIgnoreCase("m") && !letra.equalsIgnoreCase("c")) {
			System.out.println("El personaje elegido no existe en el juego.\n");
			System.out.println("Indique el personaje que desea crear: (M - Mago || C - Clérigo)");
			letra = teclado.nextLine();
		}
		
		
		if(letra.equalsIgnoreCase("m")) {
			System.out.println("Para crear un MAGO necesita introducir los siguientes campos:\n "+
					"< nombre, raza (humano, elfo, enano, orco), fuerza (0-15), inteligencia (17-20), puntos de vida (0-100) >\n"
					+"(Presione INTRO tras introducir cada campo)");
			try {
				p = new Mago(teclado.nextLine(), teclado.nextLine(), Integer.parseInt(teclado.nextLine()), 
									Integer.parseInt(teclado.nextLine()), Integer.parseInt(teclado.nextLine()));
				System.out.println("\nSu personaje ha sido creado satisfactoriamente.");
			} catch (NumberFormatException | RazaException | FuerzaException | InteligenciaException
					| PuntosVidaException | MagoInteligenciaException | MagoFuerzaException e) {
				System.out.println(e.getMessage());
			}
		}
		else if(letra.equalsIgnoreCase("c")) {
			System.out.println("Para crear un CLÉRIGO necesita introducir los siguientes campos:\n "+
					"< nombre, raza (humano, elfo, enano, orco), fuerza (18-20), inteligencia (12-16), puntos de vida (0-100), nombre de su Dios >\n"
					+"(Presione INTRO tras introducir cada campo)");
			try {
				p = new Clerigo(teclado.nextLine(), teclado.nextLine(), Integer.parseInt(teclado.nextLine()), 
										Integer.parseInt(teclado.nextLine()), Integer.parseInt(teclado.nextLine()), teclado.nextLine());
				System.out.println("\nSu personaje ha sido creado satisfactoriamente.");
			} catch (NumberFormatException | RazaException | FuerzaException | InteligenciaException
					| PuntosVidaException | ClerigoFuerzaException | ClerigoInteligenciaException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return p;
	}

	@Override
	public double minimo() {
		double min = AbstractPersonaje.VIDA_MAXIMA;
		for(AbstractPersonaje personaje: listaPersonajes) {
			if(personaje.getPuntosVidaActual()<min) {
				min = personaje.getPuntosVidaActual();
			}
		}
		return min;
	}

	@Override
	public  double maximo() {
		double max = 0;
		for(AbstractPersonaje personaje: listaPersonajes) {
			if(personaje.getPuntosVidaActual()>max) {
				max = personaje.getPuntosVidaActual();
			}
		}
		return max;
		
	}

	@Override
	public double media() {
		double suma = 0;
		for(AbstractPersonaje personaje: listaPersonajes) {
			suma+= personaje.getPuntosVidaActual();
		}
		return suma/listaPersonajes.size();
	}
		
	

}
