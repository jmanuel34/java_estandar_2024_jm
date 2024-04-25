package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pais;

/*
 * Implementar lógica de negocio de una aplicación que proporcione información
 * sobre paises. Cada pais se caracteriza por: nombre,continente,capital,habitantes
 * 
 * -Lista de continentes
 * -Lista de paises a partir del continente
 * -Pais más poblado 
 * -Tabla con paises agrupados por continente
 * -Pais a partir de su capital  
 */
public class PaisesService {
	String dir = ("/Users/josemanuelmendez/eclipse-workspace/cursoJava2024/ficheros/paises.json");

//	String dir = ("C:\\Users\\manana\\Curso Java\\Java2024\\ficheros\\paises.json");

	public Stream<Pais> getPaises() {
		try {
			Gson gson = new Gson();
			return Arrays.stream(gson.fromJson(new FileReader(dir), Pais[].class));
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// -Lista de continentes
	public List<String> continentes() {
		return getPaises()
				.map(c -> c.getContinente())
				.distinct()
				.toList();
	}

//	-Lista de paises a partir del continente
	public List<Pais> paisesEnContinente(String continente) {
		return getPaises()
				.filter(c -> c.getContinente()
				.equals(continente))
				.toList();
	}
	
	public Pais masPoblado() {
		return getPaises()
				.max(Comparator.comparingInt(p->p.getHabitantes()))
				.orElse(null);
	}

	// Tabla con paises agrupados por continente
	public Map<String, List<Pais>> listadoPorContinentes(String continente) {
		return getPaises()
				.collect(Collectors.groupingBy(p -> p.getContinente()));
	}
	
	// -Pais a partir de su capital  
	public Optional<Pais> getPaisporCapital(String capital) {
		return getPaises()
				.filter(p->p.getCapital().equals(capital))
				.findFirst();
	}
}
