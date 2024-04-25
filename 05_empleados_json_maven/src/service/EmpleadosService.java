package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Empleado;

/* 
 * Implementar lógica de negocio de una aplicación que proporcione los siguientes métodos
 * -Lista de empleados de un determinado departamento
 * -Empleado con mayor salario 
 * -Lista de departamentos
 */
//*/
public class EmpleadosService {
	
	String dir= ("C:\\Users\\manana\\Curso Java\\Java2024\\ficheros\\ciudades.json");
	
	public Stream<Empleado> getEmpleados() {
		try {
		Gson gson = new Gson();
//			return  Arrays.asList(gson.fromJson(new FileReader(dir), Empleado[].class));
			return  Arrays.stream(gson.fromJson(new FileReader(dir), Empleado[].class));
					
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Empleado> listadoPorDepartamento (String departamento) {
		return getEmpleados()				//Stream<Empleado>
			.filter(e->e.getDepartamento().equals(departamento))   //Stream<Empleado>
			.collect(Collectors.toList());
	}
	
	public Empleado mayorSalario() {
		return getEmpleados()
				.max(Comparator.comparingDouble(e->e.getSalario()))
				.orElse(null);
	}
	public List<String> listadoDepartamentos() {
		return  getEmpleados()
				.map(c->c.getDepartamento())
				.distinct()
				.toList();
	}
}
