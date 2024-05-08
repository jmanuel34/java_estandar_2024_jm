package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Cliente;

class ClientesDaoImpl implements ClientesDao {

	@Override
	public List<Cliente> findAll(int idCuenta) {
		List<Cliente> clientes = new ArrayList<Cliente>();

		try (Connection con =LocatorConnection.getConnection();) {
			String sql= "Select clientes* from clientes, titulares where "
					+ "clientes.idCliente = titulares.idcliente and dni =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idCuenta);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				clientes.add(new Cliente(rs.getInt("dni"),
						rs.getString("nombre"),
						rs.getString("direccion"),
						rs.getInt("telefono") ));			
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

}
