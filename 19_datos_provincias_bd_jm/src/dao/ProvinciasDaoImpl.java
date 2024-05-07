package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Provincia;

class ProvinciasDaoImpl implements ProvinciasDao {

	@Override
	public int saveProvincias(List<Provincia> provincias) {

		int contador = 0;
		try (Connection con = LocatorConnection.getConnection()){
			String sql = "insert into provincias(CodigoProvincia,NombreProvincia,CodigoAutonomia, ComunidadAutonoma, Capital) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(false); // Cancelamos el autocommit
			for (Provincia p : provincias) {
				ps.setString(1, p.getCodigoProvincia());
				ps.setString(2, p.getNombreProvincia());
				ps.setString(3, p.getCodigoAutonomia());
				ps.setString(4, p.getComunidadAutonoma());
				ps.setString(5, p.getCapital());
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

	@Override
	public List<String> findCodigos() {
		List<String> codigos=new ArrayList<String>();
		try (Connection con=LocatorConnection.getConnection()){
			String sql="select codigoProvincia from provincias";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				codigos.add(rs.getString(1));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return codigos;
	} 
	}

