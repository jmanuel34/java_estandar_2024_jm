package dao;

public class PedidosDaoFactory {
	
	public static PedidosDao getPedidosDao() {
		return new PedidosDaoImpl();
	}
	
	public static TiendasJsonDao getTiendasJsonDao() {
		return new TiendasJsonDaoImpl();
	}

}
