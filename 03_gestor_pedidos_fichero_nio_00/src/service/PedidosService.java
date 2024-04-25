package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import model.Pedido;
import utilidades.Util;

public class PedidosService {
	Path pt=Path.of("pedidos.csv");
	//cada pedido se graba en una línea:
	//producto,unidades,fechaPedido
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
	
	public Optional<Pedido> pedidoMasReciente() {
		
		try {
			return Files.lines(pt)
					.map(p->Util.convertirCadenaAPedido(p))//Stream<String>
					.max(Comparator.comparing(p->p.getFechaPedido()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
				
	}
	
	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) {
		return Files.lines(pt)
				.filter((Pedido) p-> Util.convertirCadenaApedido(p). getFechaPedido().isAfter(f1) &&
						p->Util.convertirCadenaAPedido(p).getFechaPedido().isBefore(f2))
				.toList();
	}
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
		Pedido pAux=new Pedido();
		pAux.setFechaPedido(LocalDate.of(1, 1, 1));
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			String linea;
			while((linea=bf.readLine())!=null) {
				Pedido p=Util.convertirCadenaAPedido(linea);
				if(Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))<
						Math.abs(ChronoUnit.DAYS.between(pAux.getFechaPedido(), fecha))) {
					pAux=p;
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return pAux;
	}
	
	public void eliminarPedido(String producto) {
		
	}
	public List<Pedido> pedidos(){
		
	}
}
