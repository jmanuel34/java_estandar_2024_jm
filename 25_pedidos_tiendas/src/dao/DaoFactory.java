package dao;

public class DaoFactory {
	public static TiendasJsonDao getFicheroPedidosDao() {
		return new TiendasJsonDaoImpl();
	}
	
	public static PedidosDao getPedidosDao() {
		return new PedidosDaoImpl();
	}
}
