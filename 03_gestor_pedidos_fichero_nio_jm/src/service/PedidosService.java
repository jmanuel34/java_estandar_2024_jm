package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import exceptions.ErrorDatosException;
import exceptions.ErrorFuenteDatosException;
import model.Pedido;
import utilidades.Util;

public class PedidosService {
//	String fichero="pedidos.csv";
	//cada pedido se graba en una línea:
	//producto,unidades,fechaPedido

	Path pt= Path.of("pedidos.csv");
/*
	public void borrarPedidos() {
		File file=new File(fichero);
		file.delete();
	}
//*/
	public void nuevoPedido(Pedido pedido) {
		try {
			Files.writeString(pt, Util.convertirPedidoACadena(pedido)+System.lineSeparator(), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoPedido(String producto, int unidades, LocalDate fechaPedido) {
		Pedido p=new Pedido(producto,unidades,fechaPedido);
		nuevoPedido(p);
	}
	
	public Pedido pedidoMasReciente () throws ErrorDatosException {
			try {
				return Files.lines(pt)
						.map(p->Util.convertirCadenaAPedido(p))
						.max(Comparator.comparing((Pedido p)->p.getFechaPedido()))  //Aqui devuelve un Optional<Pedido> 
						.orElse(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ErrorDatosException();
			}
			
	}
	
	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) throws ErrorDatosException {
		
			try {
				return Files.lines(pt)
						.map(p->Util.convertirCadenaAPedido(p))
						.filter(p->p.getFechaPedido().compareTo(f1)>=0 
										&& p.getFechaPedido().compareTo(f2)<=0)
						.collect(Collectors.toList());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ErrorDatosException();
			}
	}
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
		return Files.lines(pt)
				.min(Comparator
						.comparingLong(p->Math.abs(ChronoUnit.DAYS.between(pAux.getFechaPedido(), fecha)))
				.orElse(null);
/*
		Pedido pAux=new Pedido();
		pAux.setFechaPedido(LocalDate.of(1, 1, 1));
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			String linea;
			while((linea=bf.readLine())!=null) {
				Pedido p=Util.convertirCadenaAPedido(linea);
				if(Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))<YS
						Math.abs(ChronoUnit.DAYS.between(pAux.getFechaPedido(), fecha))) {
					pAux=p;
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return pAux;
		*/
	}
	public void eliminarPedido(String producto) {
		try {
			List<String> pedidos = Files.lines(pt)
				.map(Util::convertirCadenaAPedido)
				.filter(p->!p.getProducto().equals(producto))
				.map(Util::convertirPedidoACadena)
				.toList();
			Files.write(pt, pedidos);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public List<Pedido> mostrarPedidos() {
		
	}
}
