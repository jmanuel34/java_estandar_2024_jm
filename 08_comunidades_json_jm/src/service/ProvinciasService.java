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
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Contacto;
import model.Provincia;

public class ProvinciasService {
	
	String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
	String usuario="root";
	String password="root";
	
	private Stream<Provincia> getStreamProvincias() {
		Gson gson = new Gson();
		String url = "https://www.el-tiempo.net/api/json/v2/provincias";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
		HttpClient client = HttpClient.newBuilder().build();
		try {
			HttpResponse<String> respuesta = client.send(request, BodyHandlers.ofString());
			return Arrays.stream(gson.fromJson(respuesta.body(), Provincia[].class));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}

	}
	
	//Buscar provicia por su clave primaria
			public Provincia existeProvincia(String codigoProvincia) {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){		
			String sql="select * from provincias where CodigoProvincia=?";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, codigoProvincia);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Provincia(rs.getString("CodigoProvincia"),
							rs.getString("NombreProvincia"),
							rs.getString("ComunidadAutonoma"),
							rs.getString("Capital"));
			}
				
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	public boolean agregarProvincia(Provincia provincia) {
		if (existeProvincia(provincia.getCodigoProvincia()) !=null) return true;
		
		
	}
		
		
	public void volcarProvincias() {
		
	}
}
