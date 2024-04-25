package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public Pedido pedidoMasReciente() {
		return Files.lines(pt)//Stream<String>
				 .sorted(Comparator.comparing((Pedido p)->p.getFechaPedido(Util.convertirCadenaAPedido(p))))
				 .findFirst();
//				.collect(Collectors.averagingDouble(s->Double.parseDouble(s)));
/*		Pedido pAux=null;
		LocalDate fMax=LocalDate.of(0,1,1); //1/1/1970
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			String linea;
			while((linea=bf.readLine())!=null) {
				Pedido p=Util.convertirCadenaAPedido(linea);
				//si encontramos pedido con fecha más reciente que fMax
				//actualizamos fMax y pAux
				if(p.getFechaPedido().isAfter(fMax)) {
					fMax=p.getFechaPedido();
					pAux=p;
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return pAux;
//*/
	}
	
	public ArrayList<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) {
		ArrayList<Pedido> aux=new ArrayList<Pedido>();
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			String linea;
			while((linea=bf.readLine())!=null) {
				Pedido p=Util.convertirCadenaAPedido(linea);
				//si fecha del pedido es posterior o igual a f1 y anterior o igual a f2, se incluye
				if(p.getFechaPedido().compareTo(f1)>=0&&p.getFechaPedido().compareTo(f2)<=0) {
					aux.add(p);
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return aux;
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
	public List<Pedido> mostrarPedidos() {
		
	}
}
