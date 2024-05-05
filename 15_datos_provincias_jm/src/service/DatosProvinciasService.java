package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.JsonMunicipio;
import model.JsonProvincia;
import model.Municipio;
import model.Provincia;

public class DatosProvinciasService {
	String cadenaConexion = "jdbc:mysql://localhost:3306/comunidades";
	String usuario = "root";
	String password = "rootroot";

	private Stream<Provincia> getStreamProvincias() {
		Gson gson = new Gson();
		String url = "https://www.el-tiempo.net/api/json/v2/provincias";
		// creamos objeto request que configura la petición
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		// creamos objeto client para hacer la llamada
		HttpClient client = HttpClient.newBuilder().build();
		// realizamos la llamada
		try {
			HttpResponse<String> respuesta = client.send(request, BodyHandlers.ofString());
			return gson.fromJson(respuesta.body(), JsonProvincia.class).getProvincias().stream();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	}

	private Stream<Municipio> getStreamMunicipiosProvincia(String codigo) {
		Gson gson = new Gson();
		String url = "https://www.el-tiempo.net/api/json/v2/provincias/" + codigo + "/municipios";
		// creamos objeto request que configura la petición
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		// creamos objeto client para hacer la llamada
		HttpClient client = HttpClient.newBuilder().build();
		// realizamos la llamada
		try {
			HttpResponse<String> respuesta = client.send(request, BodyHandlers.ofString());
			return gson.fromJson(respuesta.body(), JsonMunicipio.class).getMunicipios().stream();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}

	public List<String> comunidades() {
		return getStreamProvincias().map(p -> p.getComunidadAutonoma()).distinct().toList();
	}

	public List<Provincia> provinciasComunidad(String comunidad) {
		return getStreamProvincias().filter(p -> p.getComunidadAutonoma().equals(comunidad)).toList();
	}

	public List<Municipio> municipiosComunidad(String codigoProvincia) {
		return getStreamMunicipiosProvincia(codigoProvincia).toList();
	}

	public boolean createProvincia(Provincia p) {
		if (!existeProvinciaEnBD(p.getCodigoProvincia())) {
			try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
				String sql = "insert into provincias(CodigoProvincia, NombreProvincia, CodigoAutonomia, ComunidadAutonoma, Capital) values(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(p.getCodigoProvincia()));
				ps.setString(2, p.getNombreProvincia());
				ps.setString(3, p.getCodigoAutonomia());
				ps.setString(4, p.getComunidadAutonoma());
				ps.setString(5, p.getCapital());		
				ps.execute();
				return true;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;

			}
		}
		return false;
	}

	private boolean existeProvinciaEnBD(String codigoProvincia) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "Select * from provincias where CodigoProvincia = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(codigoProvincia));
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	private boolean existeMunicipioEnBD(String codigo) {
		try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql = "Select * from Municipios where CodigoINE = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, codigo);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean createMunicipio(Municipio m) {
		if (!existeMunicipioEnBD(m.getCodigoINE())) {
			try (Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);) {
				String sql = "insert into municipios("
						+ "	CodigoINE,"
						+ " CodigoProvincia,"
						+ " NombreMunicipio,"
						+ " NombreProvincia," 
						+ " Capital,"
						+ " Poblacion,"
						+ " PoblacionMuni,"
						+ " Longitud,"
						+ " Latitud,"
						+ " Altitud,"
						+ " Superficie) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, m.getCodigoINE());
//				ps.setString(1, m.getCodigoINE().substring(1, m.getCodigoINE().length()-1));
				ps.setString(2, m.getCodigoProvincia());
				ps.setString(3, m.getNombreMunicipio());
				ps.setString(4, m.getNombreProvincia());	
				ps.setString(5, m.getNombreCapital());
				ps.setInt(6, Integer.parseInt(m.getPoblacion()));
				ps.setInt(7, Integer.parseInt(m.getPoblacionMuni()));
				ps.setDouble(8, Double.parseDouble(m.getLongitud()));
				ps.setDouble(9, Double.parseDouble(m.getLatitud()));
				ps.setInt(10, m.getAltitud());
				ps.setDouble(11, m.getSuperficie());
				ps.execute();
				return true;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;

			}
		}
		return false;
	}

}
