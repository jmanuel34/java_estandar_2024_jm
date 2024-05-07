package dao;

public class BancaDaoFactory {
	public static BancaDaoFactory getCuentasDao() {
		return new CuentasDaoImpl();
	}
	public static BancaDaoFactory getClientesDao() {
		return new ClientesDaoImpl();
	}
	public static BancaDaoFactory getMovimientosDao() {
		return new  MovimientosDaoImpl();
	}
	

}
