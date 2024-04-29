package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Alumno;
import model.Curso;

public class CursosService {
	
	String cadenaConexion="jdbc:mysql://localhost:3306/formacion";
	String usuario="root";
	String password="root";
	public Stream<Curso> leerFichero() {
		String dir= ("C:\\Users\\manana\\Curso Java\\Java2024\\archivos\\cursos.json");
		try {
			Gson gson = new Gson();
//				return  Arrays.asList(gson.fromJson(new FileReader(dir), Curso[].class));
				return  Arrays.stream(gson.fromJson(new FileReader(dir), Curso[].class));
						
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
	public boolean existe(int idCurso) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from cursos where idCurso=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idCurso);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return true;
			}
				
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean agregar(Curso curso) {
		if(existe(curso.getIdCurso())) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="insert into curso(curso,duracion,precio) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setString(1, curso.getCurso());
			ps.setInt(2, curso.getDuracion());
			ps.setInt(3, curso.getPrecio());
			ps.execute();//NO se manda otra vez la SQL
			return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public List<Curso> mostrarCursos() {
		
		return null;
	}
	
	public List<Alumno> mostrarAlumnos(String curso){
		
		return null;
	}
	
	public Alumno borrarAlumno(String dni) {
		
		return null;
	}

}
