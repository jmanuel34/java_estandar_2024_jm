package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Cliente;

public class ClientesDaoImpl implements ClientesDao {

	@Override
	public Cliente findByUsuario(String usuario) {
		try(Connection con=LocatorConnection.getConnection()){		
			String sql="select * from clientes where usuario=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, usuario);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Cliente(rs.getInt("idCliente"),
							rs.getString("usuario"),
							rs.getString("password"),
							rs.getString("email"),
							rs.getInt("telefono"));
			}
				
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
