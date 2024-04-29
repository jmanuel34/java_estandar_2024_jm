package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	String usuario = "root";
	String password = "rootroot";
	
	private boolean existeEmail(String email) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "select * from contactos where email = ?";
		
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs= st.executeQuery(sql);
			return rs.next(); 
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	// 1.-Nuevo Contacto
	// Si hay un contacto con ese email, no se añadira y devolvera false
	// No se añadira contactos con email duplicados
	public boolean agregar(Contacto contacto) {
		if (!existeEmail (contacto.getEmail())) {
			try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
				String sql = "insert into contactos(nombre, email, edad) values(?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
			// sustituir parametros por valores
				ps.setString(1, contacto.getNombre());
				ps.setString(2, contacto.getEmail());
				ps.setInt(3, contacto.getEdad());
				ps.execute(); // No se manda otra vez la Sql
			return true;			

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	// 2.-Eliminar Contacto
	// Devuelve el contacto eliminado. Si no se ha eliminado ninguno, devuelve null
	public Contacto eliminarContacto(String email) {
//*	
		Contacto contacto = null;
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {		
			
			String sql = "select * from contactos where email = ?";	
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs= st.executeQuery(sql);
			if (rs.next()) {
				 contacto = new Contacto(rs.getInt("idContacto"),
										(rs.getString("nombre")),
										(rs.getString("email")),
										(rs.getInt("edad")));
				}		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
//*/	
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
				String sql = "delete from contactos where email = (?)";
				PreparedStatement ps = con.prepareStatement(sql);
				// sustituir parametros por valores
				ps.setString(1, email);
				ps.execute(); // No se manda otra vez la Sql
				System.out.println("Registro eliminado");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		return contacto;
	}

	// 3.-Actualizar edad
	public void actualizarEdad(String email, int edad) {
		if (existeEmail(email)) {
			try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
				 String sql ="update contactos set edad = (?) where email= (?)";
				PreparedStatement ps = con.prepareStatement(sql); // sustituir parametros por valores
				ps.setInt(1,edad);
				ps.setString(2, email);
				ps.execute(); // No se manda otra vez la Sql
				System.out.println("Registro actualizado");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		else System.out.println("No existe contacto");

	}

	/*
	 * Recuperar todos los contactos
	 */
	public List<Contacto> getContactos(){
		List<Contacto> contactos= new ArrayList<Contacto>();
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {

			String sql = "select * from contactos";
			PreparedStatement ps = con.prepareStatement(sql);
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while (rs.next()) {
				contactos.add(new Contacto (rs.getInt("idContacto"),
						rs.getString("nombre"),
						rs.getString ("email"),
						rs.getInt("edad")));
			}
		
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	return contactos;
}
	
	/* Buscar contacto por su clave primaria
	 */
	private Contacto buscarContactoPorId(int idContacto ) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "select * from contactos where idContacto = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idContacto);
			ResultSet rs= st.executeQuery(sql);
			if (rs.next()) {
				return new Contacto(rs.getInt("idContacto"),
						rs.getString("nombre"),
						rs.getString ("email"),
						rs.getInt("edad"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
