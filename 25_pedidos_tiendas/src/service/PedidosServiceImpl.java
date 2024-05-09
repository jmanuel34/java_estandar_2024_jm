package service;

import java.util.List;

import dao.DaoFactory;
import dao.TiendasJsonDao;
import dao.PedidosDao;
import model.Pedido;

public class PedidosServiceImpl implements PedidosService {

	@Override
	public List<Pedido> pedidosTienda(String ruta, String tienda) {
		TiendasJsonDao fDao=DaoFactory.getFicheroPedidosDao();
		List<Pedido> pedidosFichero=fDao.getPedidos(ruta);
		//recorremos los pedidos que llegan del fichero y les asignamos 
		//tienda
		pedidosFichero.forEach(p->p.setTienda(tienda));
		return pedidosFichero;
	
	}

	@Override
	public void guardarPedidos(String ruta, String tienda) {
		List<Pedido> pedidos = pedidosTienda(ruta, tienda);
		PedidosDao pDao=DaoFactory.getPedidosDao();
		//recorremos lista de pedidos y los guardamos
		pedidos.forEach(p->pDao.save(p));

	}

}
