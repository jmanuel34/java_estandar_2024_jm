package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Cliente;

public class ClientesDaoImpl implements ClientesDao {

	@Override
	public Cliente getCliente(String usuario, String password) {
		
		try (Connection con=LocatorConnection.getConnection()){
			String sql="Select * from clientes where idCliente =? and password= ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Cliente(rs.getInt("idCliente"),
							rs.getString("usuario"),
							rs.getString("password"),
							rs.getString("email"),
							rs.getInt("telefono"));		
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return new Cliente();
	}

	@Override
	public boolean registrar(Cliente cliente) {
		try (Connection con=LocatorConnection.getConnection()){
			String sql="insert into clientes(usuario, password, email, telefono) VALUES (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cliente.getUsuario());
			ps.setString(2, cliente.getPassword());
			ps.setString(3, cliente.getEmail());
			ps.setInt(4, cliente.getTelefono());
			
			ResultSet rs = ps.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return true;
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

}

