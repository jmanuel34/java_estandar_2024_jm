package service;

/*
 * 	//cada pedido se graba en una línea:
 */ //producto,unidades,fechaPedido
//*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

import exceptions.ErrorFuenteDatosException;
import model.Pedido;
import utilidades.Util;


public class PedidosService {
	Path pt=Path.of("pedidos.csv");

	public void borrarPedidos() {
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void nuevoPedido(Pedido pedido) {		
		try {
			Files.writeString(pt, Util.convertirPedidoACadena(pedido)+System.lineSeparator(), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	public void nuevoPedido(String producto, int unidades, LocalDate fechaPedido) {
		Pedido p=new Pedido(producto,unidades,fechaPedido);
		nuevoPedido(p);
	}
	
	public Pedido pedidoMasReciente() throws ErrorFuenteDatosException{	
		try {
			return Files.lines(pt)
					.map(p->Util.convertirCadenaAPedido(p)) 	//Stream<String>
					.max(Comparator.comparing(p->p.getFechaPedido()))
					.orElse(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw ErrorFuenteDatosException();			
			throw new ErrorFuenteDatosException();
		}
				
	}
	
	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) {
		try {
			return Files.lines(pt)
					.map(Util::convertirCadenaAPedido)
					.filter(p -> p.getFechaPedido().isAfter(f1) &&
								 p.getFechaPedido().isBefore(f2))
					.toList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
		Pedido pAux=new Pedido();
		pAux.setFechaPedido(LocalDate.of(1, 1, 1));
			try {
				return Files.lines(pt)
					.map(Util::convertirCadenaAPedido)
					.min(Comparator.comparingLong(p->Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))))
					.orElse(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}				
	}
	
	public void eliminarPedido(String producto) {
		try {
			List<String> pedidos = Files.lines(pt)
									.map(Util::convertirCadenaAPedido)
									.filter(p->!p.getProducto().equals(producto))
									.map(Util::convertirPedidoACadena)
									.toList();
			Files.write(pt, pedidos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	public List<Pedido> pedidos(){
		try {
			return Files.lines(pt)
					.map(Util::convertirCadenaAPedido)
					.toList();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
