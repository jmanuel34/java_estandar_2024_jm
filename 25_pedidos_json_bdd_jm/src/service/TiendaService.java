package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dao.PedidosDao;
import dao.PedidosDaoFactory;
import model.Pedido;


public class TiendaService {
	private String ruta;
	private PedidosDao pedidosDao;
	
	public TiendaService(String ruta) {
		this.ruta = ruta;
		pedidosDao = PedidosDaoFactory.getPedidosDao();
	}
	
	

	private boolean guardarPedidos(Stream<Pedido> pedidos) {
		Stream<Pedido> p= pedidos;
		return pedidosDao.agregar(p.toList());
	}

}
