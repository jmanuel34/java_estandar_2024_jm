package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Municipio;

class MunicipiosDaoImpl implements MunicipiosDao {

	@Override
	public boolean existeMunicipio(Municipio municipio) {
		try (Connection con=LocatorConnection.getConnection()){
			String sql="Select * from  municipio where codigoINE= ?";
			PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, municipio.getCodigoINE());
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
	public void saveMunicipios(List<Municipio> municipios) {
		int contador=0;
		try (Connection con=LocatorConnection.getConnection()){
			String sql="insert into municipios(codigoINE,codigoProvincia,NombreMunicipio,NombreProvincia, "
								+ "NombreCapital,Poblacion, PoblacionMuni, Longitud, Latitud, Altitud, Superficie) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);
			for(Municipio m:municipios){
				ps.setString(1, m.getCodigoINE());
				ps.setString(2, m.getCodigoProvincia());
				ps.setString(3, m.getNombreMunicipio());			
				ps.setString(4, m.getNombreProvincia());
				ps.setString(5, m.getNombreCapital());
				ps.setInt(6, m.getPoblacion());		
				ps.setInt(7, m.getPoblacionMuni());	
				ps.setDouble(8, m.getLongitud());
				ps.setDouble(9, m.getLatitud());
				ps.setInt(10, m.getAltitud());			
				ps.setDouble(11, m.getSuperficie());
				ps.execute();
				contador++;
			}
			con.commit();
					} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}

	@Override
	public List<String> findCodigos() {
		List<String> codigos=new ArrayList<String>();
		try (Connection con=LocatorConnection.getConnection()){
			String sql="select codigoINE from municipios";
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
