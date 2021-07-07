package ejeHERENCIA.ejer3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		
		EmpleadoFijo fijo = new EmpleadoFijo("Pepe", 45, "25417L", 1530.25, 1975);
		
		System.out.println(fijo.getYearsEmpresa());
		
		EmpleadoTemporal temp = new EmpleadoTemporal("Lola", 26, "251489P", 1250, LocalDate.of(2020,10,15), LocalDate.of(2021,04,15));
		
		System.out.println(temp.calcularSueldo()+" euros.");
		
		EmpleadoPorHoras horas = new EmpleadoPorHoras("Juan", 36, "12548D", 12, 6);
		
		System.out.println(horas.calcularSueldo()+" euros.");
		
		//opcion1 para hacer una lista
		List<Empleado> empleados = new ArrayList<>();
				
		empleados.add(fijo);
		empleados.add(temp);
		empleados.add(horas);
		
		//opcion2 para hacer una lista
		List<Empleado> empl = List.of(fijo,temp,horas);
		
		

	}
	
	

}
