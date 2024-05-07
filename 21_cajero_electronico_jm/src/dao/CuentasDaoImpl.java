package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Cuenta;

public class CuentasDaoImpl implements CuentasDao {

	@Override
	public Cuenta findById(int idCuenta) {
		try (Connection con=LocatorConnection.getConnection();){
			String sql="select * from comunidades where numerocuenta=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, idCuenta);			
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				return new Cuenta(rs.getInt("numeroCuenta"),
						rs.getDouble("saldo"),
						rs.getString("tipocuenta")
						);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		return new Cuenta();
	}

	@Override
	public void updateSaldo(int idCuenta, double nuevoSaldo) {
		// TODO Auto-generated method stub
		
	}



}
