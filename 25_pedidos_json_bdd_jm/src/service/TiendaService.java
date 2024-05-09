package service;

import java.util.stream.Stream;

import model.Pedido;

public interface TiendaService {
	
	public boolean guardar(Stream<Pedido> pedidos);
//	public boolean guardarPedidos(Stream<Pedido> pedidos);
	public boolean agregarPedidos (String ruta, String tienda);

}
