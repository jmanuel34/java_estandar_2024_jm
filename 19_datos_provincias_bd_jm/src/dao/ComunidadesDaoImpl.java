package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import locator.LocatorConnection;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

public class ComunidadesDaoImpl implements ComunidadesDao {

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
	public int saveProvincias(List<Provincia> provincias) {

		int contador = 0;
		try (Connection con = LocatorConnection.getConnection()){
			String sql = "insert into provincias(codigo,nombre,codComunidad) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false); // Cancelamos el autocommit
			for (Provincia p : provincias) {
				ps.setString(1, p.getCodigo());
				ps.setString(2, p.getNombre());
				ps.setString(3, p.getCodComunidad());
				ps.execute();
				contador++;
			}
			con.commit();// Confirmamos transacccion si no hubo fallos
			return contador;
		} catch (

		SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		int contador=0;
		try (Connection con=LocatorConnection.getConnection()){
			String sql="insert into municipios(codigo,nombre,codProvincia,superficie,altitud,poblacion) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(Municipio m:municipios){
				ps.setInt(1, m.getCodigo());
				ps.setString(2, m.getNombre());
				ps.setString(3, m.getCodProvincia());
				ps.setDouble(4, m.getSuperficie());
				ps.setInt(5, m.getAltitud());
				ps.setInt(6, m.getPoblacion());
				ps.execute();
				contador++;
			}
			con.commit();
			return contador;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public boolean saveComunidad(Comunidad c) {
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

	@Override
	public int poblacionTotalProvincia(String provincia) {
		try (Connection con=LocatorConnection.getConnection()){
			String sql="Select sum(poblacion) from municipios where codigoProvincia= ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, provincia);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
		

}
