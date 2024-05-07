package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import locator.LocatorConnection;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

class ComunidadesDaoImpl implements ComunidadesDao {

	@Override
	public int saveComunidades(List<Comunidad> comunidades) {

		int contador = 0;
		try (Connection con = LocatorConnection.getConnection()){
			String sql = "insert into comunidades(codigo,nombre) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false);
			for (Comunidad c : comunidades) {
				ps.setString(1, c.getCodigo());
				ps.setString(2, c.getNombre());
				ps.execute();
				contador++;
			}
			con.commit();
			return contador;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	

	@Override
	public boolean saveComunidad(Comunidad c) {
		if (existeComunidad(c.getCodigo())) {
			return false;
		}
		try (Connection con=LocatorConnection.getConnection()){
			String sql="insert into comunidades(codigo,nombre) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, c.getCodigo());
				ps.setString(2, c.getNombre());
				ps.execute();
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	 public boolean existeComunidad(String codigo) {
		try (Connection con=LocatorConnection.getConnection()){
			String sql="Select * from  comunidades where nombre= ?";
			PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, codigo);
				ResultSet rs = ps.executeQuery();
				if (rs.next())
					return true;
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	

	@Override
	public void borrarComunidades() {
		try (Connection con=LocatorConnection.getConnection()) {
			String sql="delete from comunidades";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.execute();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}



	
		

}
