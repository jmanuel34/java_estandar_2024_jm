package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AgregarContacto {

	public static void main(String[] args) {
		String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
		String usuario= "root";
		String password = "rootroot";
		String name="user2";
		String email ="user2@gmail.com";
		int edad = 20;
		try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);){
			
			String sql="insert into contactos(nombre, email, edad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituir parametros por valores
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, edad);
			ps.execute();			//No se manda otra vez la Sql
/*
			String sql="insert into contactos(nombre, email, edad) values('"+name+","+ email, edad)";
			Statement st=con.createStatement();
			st.execute(sql);
//*/
			System.out.println("Registro añadido");
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
