package service;

import java.util.stream.Stream;

import dao.PedidosDao;
import dao.PedidosDaoFactory;
import dao.TiendasJsonDao;
import model.Pedido;


public class TiendaService {
	private String ruta;
	private PedidosDao pedidosDao;
	private TiendasJsonDao tiendasJsonDao;
	
	public TiendaService(String ruta) {
		this.ruta = ruta;
		pedidosDao = PedidosDaoFactory.getPedidosDao();
		tiendasJsonDao = PedidosDaoFactory.getTiendasJsonDao();
	}

	private boolean guardarPedidos(Stream<Pedido> pedidos) {
		Stream<Pedido> p = pedidos;
		return pedidosDao.agregar(p.toList());
	}
	private boolean guardarPedido (Pedido p) {
		return pedidosDao.agregar(p);	
	}

}
