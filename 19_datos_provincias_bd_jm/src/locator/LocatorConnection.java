package locator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocatorConnection {
	static String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
	static String usuario="root";
	static String password="rootroot";
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(cadenaConexion,usuario,password);
	}
}
