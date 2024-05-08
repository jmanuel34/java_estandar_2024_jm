package model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class Movimiento {
	private int idMovimiento;
	private int idCuenta;
	private LocalDateTime fecha;
	private double cantidad;
	private String operacion;
	
	
	
	public Movimiento( int idCuenta, LocalDateTime fecha, double cantidad, String operacion) {
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}



	public Movimiento(int idMovimiento, int idCuenta, LocalDateTime fecha, double cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}
	
}
