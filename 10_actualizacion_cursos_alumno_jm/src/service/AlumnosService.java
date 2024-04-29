package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Alumno;

public class AlumnosService {
	String cadenaConexion="jdbc:mysql://localhost:3306/formacion";
	String usuario="root";
	String password="root";
	public boolean agregar (Alumno alumno){
		if (!existe(alumno.getDni()) {
			
		}
		
	}
	public boolean existe(String dni) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from cursos where idCurso=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, idAlumno);
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
}
