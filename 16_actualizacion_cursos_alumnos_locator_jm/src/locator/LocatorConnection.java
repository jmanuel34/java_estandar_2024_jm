package locator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocatorConnection {
	String cadenaConexion="jdbc:mysql://localhost:3306/formacion";
	String usuario="root";
	String password="root";
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(cadenaConexion,usuario,password);
	}
}
