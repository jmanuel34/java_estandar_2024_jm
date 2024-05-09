package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Curso;

public class CursosJsonService {
	String dir = ("C:\\Users\\manana\\Curso Java\\Java2024\\archivos\\cursos.json");

	public List<Curso> leerFichero() {
		/*
		 * List<Curso> cursos = new ArrayList<Curso>(); Gson gson = new Gson();
		 * TypeToken<List<Curso>> typeTokenListaCursos = new TypeToken<List<Curso>>()
		 * {}; try { return gson.fromJson(new FileReader(dir), typeTokenListaCursos); }
		 * catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
		 * e.printStackTrace(); } return cursos;
		 */
		List<Curso> cursos = new ArrayList<Curso>();
		try {
			Gson gson = new Gson();
			return Arrays.asList(gson.fromJson(new FileReader(dir), Curso[].class));
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return List.of();

	}
}
