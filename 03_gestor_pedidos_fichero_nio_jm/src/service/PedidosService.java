package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.ErrorDatosException;
import exceptions.ErrorFuenteDatosException;
import model.Pedido;
import utilidades.Util;

public class PedidosService {
//	String fichero="pedidos.csv";
	// cada pedido se graba en una línea:
	// producto,unidades,fechaPedido

	Path pt = Path.of("pedidos.csv");

	public void borrarPedidos() {
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void nuevoPedido(Pedido pedido) {
		try {
			Files.writeString(pt, Util.convertirPedidoACadena(pedido) + System.lineSeparator(),
					StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void nuevoPedido(String producto, int unidades, LocalDate fechaPedido) {
		Pedido p = new Pedido(producto, unidades, fechaPedido);
		nuevoPedido(p);
	}

	public Pedido pedidoMasReciente() throws ErrorDatosException {
		try {
			return Files.lines(pt).map(p -> Util.convertirCadenaAPedido(p))
					.max(Comparator.comparing((Pedido p) -> p.getFechaPedido())) // Aqui devuelve un Optional<Pedido>
					.orElse(null);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorDatosException();
		}

	}

	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) throws ErrorDatosException {

		try {
			return Files.lines(pt).map(p -> Util.convertirCadenaAPedido(p))
					.filter(p -> p.getFechaPedido().compareTo(f1) >= 0 && p.getFechaPedido().compareTo(f2) <= 0)
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorDatosException();
		}
	}

	public Pedido pedidoProximoFecha(LocalDate fecha) throws ErrorFuenteDatosException {
		try {
			return Files.lines(pt).map(p -> Util.convertirCadenaAPedido(p))
					.min(Comparator.comparingLong(p -> Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))))
					.orElse(null);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}
	}

	public void eliminarPedido(String producto) {
		try {
			List<String> pedidos = Files.lines(pt).map(Util::convertirCadenaAPedido)
					.filter(p -> !p.getProducto().equals(producto)).map(Util::convertirPedidoACadena).toList();
			Files.write(pt, pedidos);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public List<Pedido> mostrarPedidos() throws ErrorFuenteDatosException {
		try {
			return Files.lines(pt).map(p -> Util.convertirCadenaAPedido(p)).toList();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}
	}
}
