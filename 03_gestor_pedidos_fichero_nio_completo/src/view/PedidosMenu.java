package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.Pedido;
import service.PedidosService;

public class PedidosMenu {
	static PedidosService service=new PedidosService();
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		do {
			//presentar menu
			//leer opción y comprobar opcion elegida
			presentarMenu();
			try{
				opcion=Integer.parseInt(sc.nextLine());
				switch(opcion) {
					case 1:
						agregarPedido();
						break;
					case 2:
						mostrarReciente();
						break;
					case 3:
						pedidosEntreFechas();
						break;
					case 4:
						pedidoProximoAFecha();
						break;
					case 5:
						mostrarPedidos();
						break;
					case 6:
						eliminar();
						break;
					case 7:
						System.out.println("Adios!");
						break;
					default:
						System.out.println("Opción no válida!");
				}
			}
			catch(NumberFormatException ex) {
				System.out.println("Debe ser un valor numérico!!");
			}
		}while(opcion!=7);
	}
	static void presentarMenu() {
		System.out.println("""
				1.- Agregar Pedido
				2.- Pedido más reciente
				3.- Pedidos entre fechas
				4.- Pedido proximo a fecha
				5.- Mostrar Pedidos
				6.- Eliminar pedido
				7.- Salir
				
				""");
	}
	static void agregarPedido()  {
		Scanner sc=new Scanner(System.in);
		DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		System.out.println("Producto:");
		String producto=sc.nextLine();
		System.out.println("Unidades:");
		int unidades=Integer.parseInt(sc.nextLine());
		System.out.println("Fecha pedido (dia/mes/año):");
		LocalDate fecha=LocalDate.parse(sc.nextLine(),sdf);	
		Pedido p=new Pedido(producto, unidades, fecha);
		service.nuevoPedido(p);
	}
	static void mostrarReciente() {
		Pedido p=service.pedidoMasReciente();
		DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.print("Producto: "+p.getProducto()+" ");
		System.out.print("Unidades: "+p.getUnidades()+" ");
		System.out.println("Fecha pedido: "+p.getFechaPedido().format(sdf)+" ");
	}
	static void pedidosEntreFechas(){
		Scanner sc=new Scanner(System.in);
		DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		System.out.println("Fecha inicio (dia/mes/año):");
		LocalDate fecha1=LocalDate.parse(sc.nextLine(),sdf);	
		System.out.println("Fecha límite (dia/mes/año):");
		LocalDate fecha2=LocalDate.parse(sc.nextLine(),sdf);	
		List<Pedido> pedidosEncontrados=service.pedidosEntreFechas(fecha1, fecha2);
		for(Pedido p:pedidosEncontrados) {
			System.out.print("Producto: "+p.getProducto()+" ");
			System.out.print("Unidades: "+p.getUnidades()+" ");
			System.out.println("Fecha pedido: "+p.getFechaPedido().format(sdf)+" ");
		}
	}
	
	static void pedidoProximoAFecha() {
		Scanner sc=new Scanner(System.in);
		DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd/MM/yyyy");	
		System.out.println("Introduzca la fecha: (dd/MM/yyyy): ");
		LocalDate fecha=LocalDate.parse(sc.nextLine(),sdf);
		Pedido pedido = service.pedidoProximoFecha(fecha);
		System.out.print("Producto: "+pedido.getProducto()+" ");
		System.out.print("Unidades: "+pedido.getUnidades()+" ");
		System.out.println("Fecha pedido: "+pedido.getFechaPedido().format(sdf)+" ");
		
	}
	static void mostrarPedidos() {		
		List<Pedido> pedidos = service.pedidos();
		DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd/MM/yyyy");	

		for(Pedido p:pedidos) {
			System.out.print("Producto: "+p.getProducto()+" ");
			System.out.print("Unidades: "+p.getUnidades()+" ");
			System.out.println("Fecha pedido: "+p.getFechaPedido().format(sdf)+" ");
		}
		
	}
//*	
	static void eliminar() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca el producto: ");
		String nombre = sc.nextLine();
		service.eliminarPedido(nombre);
	}
//*/
}
