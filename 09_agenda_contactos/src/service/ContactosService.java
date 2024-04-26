package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contacto;

/*
 * 1.-Nuevo Contacto
 * 2.-Eliminar Contacto
 * 3.-Actualizar edad
 * 4.-Salir
 * 1: Se piden los datos del nuevo contacto y se guarda
 * 2: Solicita el email y borra el contacto con dicho email
 * 3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto 
 */
public class ContactosService {
	String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
	String usuario= "root";
	String password = "root";
/*	
	private Connection getConexion() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
		String usuario= "root";
		String password = "root";
		try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);
	}
//*/	
	public agregar(Contacto contacto) {
		try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);){
					
					String sql="insert into contactos(nombre, email, edad) values(?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					//sustituir parametros por valores
					ps.setString(1, contacto.getNombre());
					ps.setString(2, contacto.getEmail());
					ps.setInt(3, contacto.getEdad());
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
