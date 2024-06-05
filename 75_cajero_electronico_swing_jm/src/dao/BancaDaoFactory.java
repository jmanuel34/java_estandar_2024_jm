package dao;

public class BancaDaoFactory {
	
	public static CuentasDao getCuentasDao() {
		return new CuentasDaoImpl();
	}
	public static ClientesDao getClientesDao() {
		return new ClientesDaoImpl();
	}
	public static MovimientosDao getMovimientosDao() {
		return new MovimientosDaoImpl();
	}
	

}
