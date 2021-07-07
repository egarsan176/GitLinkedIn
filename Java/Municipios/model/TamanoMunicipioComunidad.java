package com.municipios.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.municipios.excep.ComunidadNotFoundException;
import com.municipios.excep.DescripcionNotFoundException;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {
		this.lista = new ArrayList<Comunidad>();
		leerJson();
	}
	
	private void leerJson() {
		String linea;
		StringBuilder sb = new StringBuilder();
		
		try {
		
			FileReader flujoLectura = new FileReader("./ficheros/tamanoMunicipioComunidad.json"); 
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			
			linea = filtroLectura.readLine();
			while(linea!=null) {
				sb.append(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		
		
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero ");
		}catch(IOException e){
			System.out.println( e.getMessage());
		}
		
		Gson gson = new Gson();
		
		lista = gson.fromJson(sb.toString(), new TypeToken<ArrayList<Comunidad>>(){}.getType());
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Comunidad comunidad : lista) {
			sb.append("\n"+comunidad+"\n");
		}
		return sb.toString();
	}
	
	

	public String mostrarTodosLosDatos(int year) {

		StringBuilder sb = new StringBuilder();
		

		for (Comunidad c : lista) {

			sb.append("\n" + c.getNombre() + "\n");

			sb.append(c.getDatoAnno(year));
		}
		
		
		return sb.toString();
	}

	
	public String mostrarDatosDeUnaComunidad(String comunidadNombre, int year) throws ComunidadNotFoundException{
		
		StringBuilder sb = new StringBuilder();
	try {
		
		Comunidad c = this.lista.get(this.lista.indexOf(new Comunidad(comunidadNombre)));// Saco la comunidad que me
																						// interesa
		sb.append("\n" + c.getNombre() + "\n");

		sb.append(c.getDatoAnno(year));
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
		
		return sb.toString();
	}

	public void addDato(String nombreComunidad, String descrip, int year, int valor) throws ComunidadNotFoundException, DescripcionNotFoundException {
		
		try {
			Comunidad c = this.lista.get(this.lista.indexOf(new Comunidad(nombreComunidad)));// Saco la comunidad que me
																					// interesa
			c.addDato(year, valor, descrip);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean comprobarValorTotal(String comunidad, int year) {
		boolean resul = true;
		
		Comunidad c = this.lista.get(this.lista.indexOf(new Comunidad(comunidad)));
		
		if(c.compruebaTotal(year) != c.consigueDatoTotal(year)) {
			resul = false;
			System.out.println("Incorrecto. El dato debería ser "+ c.consigueDatoTotal(year));
		}
		
		return resul;
	}

	public void crearNuevoFicheroJson(String fichero) {
		
		try {
			FileWriter flujoEscritura = new FileWriter(fichero+".json");
			
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
		
			final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
			final String representacionBonita = prettyGson.toJson(lista);
			
			filtroEscritura.println(representacionBonita);
			
			filtroEscritura.close();
			flujoEscritura.close();
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	
	
}