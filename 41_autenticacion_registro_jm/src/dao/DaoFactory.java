package dao;

public class DaoFactory {
	public static ClientesDao getClientesDao() {
		return new ClientesDaoImpl();
	}

}