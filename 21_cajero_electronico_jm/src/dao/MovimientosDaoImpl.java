package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Movimiento;

public class MovimientosDaoImpl implements MovimientosDao {

	@Override
	public List<Movimiento> findByCuenta(int idCuenta) {
		List<Movimiento> mov = new ArrayList<Movimiento>();
		try (Connection con = LocatorConnection.getConnection();) {
			String sql = "select * from movimientos where idCuenta=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idCuenta);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				mov.add(new Movimiento(rs.getInt("idMovimiento"), 
						rs.getInt("idCuenta"),
						rs.getDate("fecha").toLocalDate(), 
						rs.getDouble("cantidad"), 
						rs.getString("operacion")					
						));
			}
			return mov;
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
		return null;
	}

	@Override
	public void save(Movimiento movimiento) {
		List<Movimiento> mov = new ArrayList<Movimiento>();
		try (Connection con = LocatorConnection.getConnection();) {
			String sql = "insert into movimientos (idCuenta, fecha, cantidad, operacion) " + "VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}
}
