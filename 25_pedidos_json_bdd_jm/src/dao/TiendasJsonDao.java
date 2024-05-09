package dao;

import java.util.List;

import model.Pedido;

public interface TiendasJsonDao {
	List<Pedido> getPedidos(String ruta, String tienda);

}
