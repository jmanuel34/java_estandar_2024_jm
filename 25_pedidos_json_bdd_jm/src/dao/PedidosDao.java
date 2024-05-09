package dao;

import java.util.List;

import model.Pedido;

public interface PedidosDao {
	public boolean agregar(Pedido pedido);
	
	public boolean agregar (List<Pedido> pedidos);
	public Pedido findById(Pedido p);
	public Pedido recuperar(int idPedido);
	public void actualizar(Pedido pedido);
	public void borrar (Pedido pedido);

}
