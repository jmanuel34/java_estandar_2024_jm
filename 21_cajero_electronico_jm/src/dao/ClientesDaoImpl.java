package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Cliente;

public class ClientesDaoImpl implements ClientesDao {

	@Override
	public List<Cliente> findAll(int idCuenta) {
		List<Cliente> clientes = new ArrayList<Cliente>();

		try (Connection con =LocatorConnection.getConnection();) {
			String sql= "Select * from clientes";
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
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
