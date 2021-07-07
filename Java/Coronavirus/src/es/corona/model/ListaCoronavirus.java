package es.corona.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

import es.corona.comp.Contagiados;
import es.corona.comp.Curados;
import es.corona.comp.Fallecidos;
import es.corona.enume.Meses;


public class ListaCoronavirus {

	private List<Corona> lista;

	public ListaCoronavirus() {
		super();
		this.lista = new ArrayList<Corona>();
		leerJson(lista);
	}
	
	private void leerJson(List<Corona> lista) { //lee los casos diagnosticados (+fallecidos+curados)
		
		String linea;
		StringBuilder sb = new StringBuilder();
		try
		{
			FileReader flujoLectura=new FileReader("./ficheros/casos_diagnosticados_de_c.json");
			BufferedReader filtroLectura=new BufferedReader(flujoLectura);
			linea=filtroLectura.readLine();
			while ( linea!=null)
			{
				sb.append(linea);
				linea=filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
			}
		catch(FileNotFoundException e){
		System.out.println("No existe el fichero ");
		}
		catch(IOException e){
		System.out.println( e.getMessage());
		}
		
		Gson gson = new Gson();
		LecturaDatos l = gson.fromJson(sb.toString(), LecturaDatos.class);
		
		int contagiados = 0;
		int aux = 0;
		
		for (Metrica m : l.getDatos().getMetricas()) { //recorro la clase metricas
			for(Informacion inf : m.getInformacion()) { //recorro la clase inf de una metrica
				
				contagiados = (int) inf.getValor(); //guardo el numero de contagiados
				
				Corona c = new Corona(inf.getPeriodo(), inf.getAgno(), contagiados-aux, 0, 0);
				lista.add(c);
				aux = (int) inf.getValor(); //modifico en aux el valor para que ir haciendo el decremento en cada corona nuevo
			}
		}
		
		
		leerJsonFallecidos(lista);
		leerJsonCurados(lista);
	}
	
	private void leerJsonFallecidos(List<Corona> lista) { //lee los casos de fallecidos
		
		String linea;
		StringBuilder sb = new StringBuilder();
		try
		{
			FileReader flujoLectura=new FileReader("./ficheros/muertos_por_coronavirus_e.json");
			BufferedReader filtroLectura=new BufferedReader(flujoLectura);
			linea=filtroLectura.readLine();
			while ( linea!=null)
			{
				sb.append(linea);
				linea=filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
			}
		catch(FileNotFoundException e){
		System.out.println("No existe el fichero ");
		}
		catch(IOException e){
		System.out.println( e.getMessage());
		}
		
		Gson gson = new Gson();
		LecturaDatos l = gson.fromJson(sb.toString(), LecturaDatos.class);
		
		int fallecidos = 0;
		int aux = 0;
		
		for(Metrica m : l.getDatos().getMetricas()) { //recorro la clase metrica
			for(Informacion inf : m.getInformacion()) { //recorro la clase inf de la metrica
				
				fallecidos = (int) inf.getValor(); //guardo el valor de fallecidos
				Corona c = new Corona(inf.getPeriodo(), inf.getAgno(), 0, 0, fallecidos);
				
				if(!lista.contains(c)) { //compruebo si la lista ya contiene ese corona
					lista.add(c); //si no lo contiene lo añado
				}else {
					lista.get(lista.indexOf(c)).setFallecidos(fallecidos-aux); //si lo contiene, cojo su posicion y modifico el valor de fallecidos
				}
				
				aux = (int) inf.getValor(); //modifico en aux el valor para que ir haciendo el decremento en cada corona nuevo
			}
		}
		
		
	}
	
	private void leerJsonCurados(List<Corona> lista) { //lee los casos curados
		
		String linea;
		StringBuilder sb = new StringBuilder();
		try
		{
			FileReader flujoLectura=new FileReader("./ficheros/evolucion_de_casos_curado.json");
			BufferedReader filtroLectura=new BufferedReader(flujoLectura);
			linea=filtroLectura.readLine();
			while ( linea!=null)
			{
				sb.append(linea);
				linea=filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
			}
		catch(FileNotFoundException e){
		System.out.println("No existe el fichero ");
		}
		catch(IOException e){
		System.out.println( e.getMessage());
		}
		
		Gson gson = new Gson();
		LecturaDatos l = gson.fromJson(sb.toString(), LecturaDatos.class);
		
		int curados = 0;
		int aux = 0;
		
		for(Metrica m : l.getDatos().getMetricas()) { //recorro la clase metrica
			for(Informacion inf : m.getInformacion()) { //recorro la clase inf de la metrica
				
				curados = (int) inf.getValor(); //guardo el valor de curados
				Corona c = new Corona(inf.getPeriodo(), inf.getAgno(), 0, curados, 0);
				
				if(!lista.contains(c)) { //compruebo si la lista ya contiene ese corona
					lista.add(c); //si no lo contiene lo añado
				}else {
					lista.get(lista.indexOf(c)).setCurados(curados-aux); //si lo contiene, cojo su posicion y modifico el valor de curados
				}
				
				aux = (int) inf.getValor(); //modifico en aux el valor para que ir haciendo el decremento en cada corona nuevo
			}
		}
		
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Corona c:lista) {
			sb.append(c+"\n");
		}
		
		return sb.toString();
	}

	
	////////////////////////////////////////////////////////////////////// METODOS DEL MAIN >>

	/**
	 * mostrar el día en el que se produjo menos contagios, el día en el que
	se produjo menos muertes y el día en que se produjeron más altas.
	 * @return
	 */
	public String mostrarMejorDia() {
	
		StringBuilder sb = new StringBuilder();
		
		//mostrar mejor dia contagiados
		Collections.sort(lista, new Contagiados());
		sb.append("Día en el que se produjeron menos contagios: "+lista.get(0).getFecha()+" ("+lista.get(0).getContagios()+" contagios/día).\n");
		
		
		//mostrar mejor dia fallecidos
		Collections.sort(lista, new Fallecidos());
		sb.append("Día en el que se produjeron menos fallecidos: "+lista.get(0).getFecha()+" ("+lista.get(0).getFallecidos()+" fallecidos/día).\n");
		
		//mostrar mejor dia de curados
		Collections.sort(lista, new Curados());
		//System.out.println(lista);
		sb.append("Día en el que se produjeron más altas: "+lista.get(0).getFecha()+" ("+lista.get(0).getCurados()+" altas/día).\n");
		
		
		return sb.toString();
	}

	/**
	 * mostrar el día en el que se produjo menos contagios, el día en el que
	se produjo menos muertes y el día en que se produjeron más altas a partir de un dia concreto
	 * @param dia
	 * @param mes
	 * @return
	 */
	public String mostrarMejorDiaDeFecha(int dia, String mes, int anio) {
		
		StringBuilder sb = new StringBuilder();
		
		int month = Meses.valueOf(mes.toUpperCase()).getNumero(); //paso el string del mes al valor numerico
		
		LocalDate fecha = LocalDate.of(anio, month, dia);
		
		List<Corona> nueva = new ArrayList<Corona>(); //creo una nueva lista en la que solo voy a guardar las que coinciden a partir de x fecha
		
		for (Corona c : lista) {
			if(c.getFecha().isEqual(fecha) || c.getFecha().isAfter(fecha)) { //si es fecha igual o posterior la saco
				nueva.add(c);
			}
		}
		sb.append("A partir del "+fecha+":\n");
		
		//mostrar mejor dia contagiados
		Collections.sort(nueva, new Contagiados());
		sb.append("Día en el que se produjeron menos contagios: "+nueva.get(0).getFecha()+" ("+nueva.get(0).getContagios()+" contagios/día).\n");
		
		
		//mostrar mejor dia fallecidos
		Collections.sort(nueva, new Fallecidos());
		sb.append("Día en el que se produjeron menos fallecidos: "+nueva.get(0).getFecha()+" ("+nueva.get(0).getFallecidos()+" fallecidos/día).\n");
		
		//mostrar mejor dia de curados
		Collections.sort(nueva, new Curados());
		sb.append("Día en el que se produjeron más altas: "+nueva.get(0).getFecha()+" ("+nueva.get(0).getCurados()+" altas/día).\n");

		
		
		return sb.toString();
	}

	/**
	 * mostrar el día en el que se produjo más contagios, el día en el que se
	produjo más muertes y el día en que se produjeron menos altas.
	 * @return
	 */
	public String mostrarPeorDia() {
		
		StringBuilder sb = new StringBuilder();
		
		//mostrar peor dia contagiados
		Collections.sort(lista, new Contagiados());
		sb.append("Día en el que se produjeron más contagios: "+lista.get(lista.size()-1).getFecha()+" ("+lista.get(lista.size()-1).getContagios()+" contagios/día).\n");
		
		
		//mostrar peor dia fallecidos
		Collections.sort(lista, new Fallecidos());
		sb.append("Día en el que se produjeron más fallecidos: "+lista.get(lista.size()-1).getFecha()+" ("+lista.get(lista.size()-1).getFallecidos()+" fallecidos/día).\n");
		
		//mostrar peor dia de curados
		Collections.sort(lista, new Curados());
		sb.append("Día en el que se produjeron menos altas: "+lista.get(lista.size()-1).getFecha()+" ("+lista.get(lista.size()-1).getCurados()+" altas/día).\n");
		
		
		return sb.toString();
	}
	
	/**
	 * mostrar el día en el que se produjo más contagios, el día en el que se
	produjo más muertes y el día en que se produjeron menos altas a partir de un dia concreto
	 * @param day
	 * @param month
	 * @return
	 */
	public String mostrarPeorDiaDeFecha(int day, String month, int year) {
		StringBuilder sb = new StringBuilder();
		
		int mes = Meses.valueOf(month.toUpperCase()).getNumero(); //paso el string del mes al valor numerico
		
		LocalDate fecha = LocalDate.of(year, mes, day);
		
		List<Corona> nueva = new ArrayList<Corona>(); //creo una nueva lista en la que solo voy a guardar las que coinciden a partir de x fecha
		
		for (Corona c : lista) {
			if(c.getFecha().isEqual(fecha) || c.getFecha().isAfter(fecha)) { //si es fecha igual o posterior la saco
				nueva.add(c);
			}
		}
		sb.append("A partir del "+fecha+":\n");
		
		//mostrar peor dia contagiados
		Collections.sort(nueva, new Contagiados());
		sb.append("Día en el que se produjeron más contagios: "+nueva.get(nueva.size()-1).getFecha()+" ("+nueva.get(lista.size()-1).getContagios()+" contagios/día).\n");
		
		
		//mostrar peor dia fallecidos
		Collections.sort(nueva, new Fallecidos());
		sb.append("Día en el que se produjeron más fallecidos: "+nueva.get(nueva.size()-1).getFecha()+" ("+nueva.get(lista.size()-1).getFallecidos()+" fallecidos/día).\n");
		
		//mostrar peor dia de curados
		Collections.sort(nueva, new Curados());
		sb.append("Día en el que se produjeron menos altas: "+nueva.get(nueva.size()-1).getFecha()+" ("+nueva.get(nueva.size()-1).getCurados()+" altas/día).\n");
				
		
		return sb.toString();
	}
	/**
	 * mostrar número de contagios, número de muertes y número de curados en un día
	 * @param dia1
	 * @param mes1
	 * @return
	 */
	public String mostrarNumeroDeUnDia(int dia1, String mes1, int anio1) {
		
		StringBuilder sb = new StringBuilder();
		int contagiados = 0;
		int fallecidos = 0;
		int curados = 0;
		boolean encontrada = false;
		
		int mes = Meses.valueOf(mes1.toUpperCase()).getNumero(); //paso el string del mes al valor numerico
		
		LocalDate fecha = LocalDate.of(anio1, mes, dia1);
		
		for (Corona c : lista) {
			if(c.getFecha().isEqual(fecha) && !encontrada) {
				contagiados = c.getContagios();
				fallecidos = c.getFallecidos();
				curados  = c.getCurados();
				encontrada = true;
			}
		}
		sb.append("Para el día "+fecha+", el número de contagios fue de "+contagiados+", el número de fallecidos de "+fallecidos+" y el número de curados de "+curados+".");
		
		return sb.toString();
	}
	
	public String mostrarMedia() {
		int contagiados = 0;
		int fallecidos = 0;
		int curados = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(Corona corona: this.lista) {
			contagiados += corona.getContagios();
			fallecidos += corona.getFallecidos();
			curados += corona.getCurados();
			
			
		}
		sb.append("La media de contagios es de "+Math.round(contagiados/lista.size())+".\n");
		sb.append("La media de fallecidos es de "+Math.round(fallecidos/lista.size())+".\n");
		sb.append("La media de curados es de "+curados/lista.size()+".\n");
		
		return sb.toString();
	}

}
