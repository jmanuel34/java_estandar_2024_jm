package model;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class Movimiento {
	private int idMovimiento;
	private int idCuenta;
	private LocalDate fecha;
	private double cantidad;
	private String operacion;
	
	public Movimiento(int idMovimiento, int idCuenta, LocalDate fecha, double cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}
	
	public Movimiento( int idCuenta, LocalDate fecha, double cantidad, String operacion) {
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}
	
}
