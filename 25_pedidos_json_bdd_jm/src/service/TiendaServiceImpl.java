package service;

import java.util.List;
import java.util.stream.Stream;

import dao.PedidosDao;
import dao.PedidosDaoFactory;
import dao.TiendasJsonDao;
import model.Pedido;


public class TiendaServiceImpl implements TiendaService {
	private String ruta;
	private String tienda;
	private PedidosDao pedidosDao;
	private TiendasJsonDao tiendasJsonDao;
	
	public TiendaServiceImpl() {
		pedidosDao = PedidosDaoFactory.getPedidosDao();
		tiendasJsonDao = PedidosDaoFactory.getTiendasJsonDao();
	}

	@Override
	public boolean guardar(Stream<Pedido> pedidos) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean agregarPedidos(String ruta, String tienda) {
		boolean resultado = false;
		List<Pedido> pedidos = tiendasJsonDao.getPedidos(ruta, tienda);
		for (Pedido p: pedidos) {
			p.setTienda(tienda);
			if (pedidosDao.agregar(p)) resultado = true;
			else resultado = false;
		} 
		return resultado;	
	}
}
