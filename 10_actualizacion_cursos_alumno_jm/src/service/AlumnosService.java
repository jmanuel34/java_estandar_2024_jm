package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Alumno;

public class AlumnosService {
	String cadenaConexion="jdbc:mysql://localhost:3306/formacion";
	String usuario="root";
	String password="root";
	
	public boolean agregar (Alumno alumno){
		if (!existe(alumno.getDni())) {
			try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
				String sql="""			
							insert into (dni, nombre, edad, nota, idCurso)
							VALUES (?,?,?,?,?)
							""" ;
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, alumno.getDni());
				st.setString(2, alumno.getNombre());
				st.setInt(3, alumno.getEdad());
				st.setDouble(4, alumno.getNota());
				st.setInt(5, alumno.getIdCurso());
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					return true;
				}
					
			}catch(SQLException ex) {
				ex.printStackTrace();
			}	
		}
		return false;		
	}
	
	
	public boolean existe(String dni) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from cursos where dni=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, dni);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				return true;
			}
				
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public List<Alumno> mostrarAlumnos(String curso){
		
		return null;
	}
	
	public Alumno borrarAlumno(String dni) {
		
		return null;
	}

}
