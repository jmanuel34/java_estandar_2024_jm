package view;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import service.CajeroService;
import service.CajeroServiceFactoy;

public class Cajero {

	public static void main(String[] args) {
		CajeroService cajero = CajeroServiceFactoy.getCajeroService();
		Cliente cliente = new Cliente();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca nombre del cliente: ");
		cliente.setNombre(sc.nextLine());
		System.out.println("Introduzca dni del cliente: ");
		cliente.setDni(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduzca la direccion del cliente: ");
		cliente.setDireccion(sc.nextLine());
		System.out.println("Introduzca telefono del cliente: ");
		cliente.setTelefono(Integer.parseInt(sc.nextLine()));
		if (cajero.save(cliente)) System.out.println("Cliente añadido");
		
		Cuenta cuenta= cajero.obtenerCuenta(1000);
		System.out.println("Cuenta: "+ cuenta.getNumeroCuenta()+ " Saldo: "+ cuenta.getSaldo()+" Tipo: "+cuenta.getTipoCuenta());
		
		List<Movimiento> movs=cajero.obtenerMovimientos(1000);
			for (Movimiento m: movs) {
				System.out.println("Id:" +m.getIdCuenta()+ "Cuenta: "+m.getIdCuenta()
				+ "Fecha: "+m.getFecha()+ " Cantidad: "+m.getCantidad()+ " Operacion: "+ m.getOperacion());
			}
		List<Cliente> clientes = cajero.obtenerTitulares(1000);
		for (Cliente c:clientes) {
			System.out.println("Dni: "+c.getDni()+" Nombre: "+c.getNombre()+" Direccion: "+c.getDireccion());
		}
			
			
		
	}

}
