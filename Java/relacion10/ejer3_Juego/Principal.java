package relac10.AvanzPOO.ejer3_Juego;

import relac10.AvanzPOO.ejer3_Juego.Excep.ClerigoFuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.ClerigoInteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.FuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.InteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.MagoFuerzaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.MagoInteligenciaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.PuntosVidaException;
import relac10.AvanzPOO.ejer3_Juego.Excep.RazaException;


public class Principal {

	public static void main(String[] args) {
		
		try {
			Mago A = new Mago("Gandalf", "elfo", 10, 19, 100);
			Mago B = new Mago("Sauron", "enano", 9, 17,100);
			Clerigo C = new Clerigo("Frodo", "humano", 19, 15, 100, "Odin" );
			
			System.out.println(">> Imprimir los datos de los tres personajes: \n");
			System.out.println(A.toString()+"\n");
			System.out.println(B.toString()+"\n");
			System.out.println(C.toString()+"\n");
			
			System.out.println("---------------------------\n");
			
			System.out.println(">> El Mago A aprende 2 hechizos. El Mago B aprende 1 hechizo. Mostrar los datos \n");
			A.aprendeHechizo("Abracadabra");
			A.aprendeHechizo("Pata de Cabra");
			B.aprendeHechizo("Supercalifraje");
			System.out.println(A.toString()+"\n");
			System.out.println(B.toString()+"\n");
			
			System.out.println("---------------------------\n");
			
			System.out.println(">> El Mago A lanza un hechizo sobre el Mago B. El Mago B lanza un hechizo sobre el Mago A \n");
			A.lanzaHechizo(B, "Pata de Cabra");  //solucionar NullPointer
			B.lanzaHechizo(A, "Supercalifraje");
			System.out.println(A.toString()+"\n");
			System.out.println(B.toString()+"\n");
			
			System.out.println("---------------------------\n");
			
			System.out.println(">> El Clerigo cura al Mago B \n");
			C.curar(B);
			System.out.println(A.toString()+"\n");
			System.out.println(B.toString()+"\n");
			
			System.out.println("---------------------------\n");
			
			System.out.println(">> El Mago A lanza un hechizo sobre el Mago B. \n");
			A.lanzaHechizo(B, "Abracadabra");
			
			System.out.println("---------------------------\n");
			
			System.out.println(">> Imprimir los datos de los tres personajes: \n");
			System.out.println(A.toString()+"\n");
			System.out.println(B.toString()+"\n");
			System.out.println(C.toString()+"\n");
			
			
		} catch (RazaException | FuerzaException | InteligenciaException | PuntosVidaException
				| MagoInteligenciaException | MagoFuerzaException e) {
			System.out.println(e.getMessage());
		} catch (ClerigoFuerzaException | ClerigoInteligenciaException e) {
			System.out.println(e.getMessage());
		}
		
	
		

	}

}
