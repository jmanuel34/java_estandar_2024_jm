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

		try (Connection con = LocatorConnection.getConnection();) {
			String sql = "Select * from clientes, titulares where "
					+ "titulares.idCliente = clientes.dni and titulares.idCuenta =?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idCuenta);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				clientes.add(new Cliente(rs.getInt("dni"), rs.getString("nombre"), rs.getString("direccion"),
						rs.getInt("telefono")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public boolean save(Cliente cliente) {
		try (Connection con = LocatorConnection.getConnection()) {
			String sql = "INSERT INTO clientes () VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getTelefono());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
