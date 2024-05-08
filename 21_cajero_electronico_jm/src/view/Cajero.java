package view;

import java.util.List;

import model.Cuenta;
import model.Movimiento;
import service.CajeroService;
import service.CajeroServiceFactoy;

public class Cajero {

	public static void main(String[] args) {
		CajeroService cajero = CajeroServiceFactoy.getCajeroService();	
		Cuenta cuenta= cajero.obtenerCuenta(1000);
		System.out.println("Cuenta: "+ cuenta.getNumeroCuenta()+ " Saldo: "+ cuenta.getSaldo()+" Tipo: "+cuenta.getTipoCuenta());
		
		List<Movimiento> movs=cajero.obtenerMovimientos(1000);
			for (Movimiento m: movs) {
				System.out.println("Id:" +m.getIdCuenta()+ "Cuenta: "+m.getIdCuenta()
				+ "Fecha: "+m.getFecha()+ "Cantidad: "+m.getCantidad()+ "Operacion: "+ m.getOperacion());
			}
		
	}

}
