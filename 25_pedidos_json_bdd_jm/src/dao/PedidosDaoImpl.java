package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import locator.LocatorConnection;
import model.Pedido;

public class PedidosDaoImpl implements PedidosDao {

	@Override
	public boolean agregar(Pedido pedido) {
		try (Connection con = LocatorConnection.getConnection();) {
			String sql = "insert into pedidos (producto, tienda, precio) " + "VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pedido.getProducto());
			ps.setString(2, pedido.getTienda());
//			ps.setTimestamp(2, Timestamp.valueOf(pedido.getFecha()));
			ps.setDouble(3, pedido.getPrecio());
			ps.execute();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return false;

	}
	
	@Override
	public boolean agregar(List<Pedido> pedidos) {
		try (Connection con = LocatorConnection.getConnection()){
			String sql = "insert into pedidos(producto, tienda, precio) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false); // Cancelamos el autocommit
			for (Pedido p : pedidos) {
				ps.setString(1, p.getProducto());
				ps.setString(2, p.getTienda());
				ps.setDouble(3, p.getPrecio());
			}
			con.commit();// Confirmamos transacccion si no hubo fallos
			return true;
		} catch (

		SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public Pedido recuperar(int idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pedido findById(Pedido p) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
