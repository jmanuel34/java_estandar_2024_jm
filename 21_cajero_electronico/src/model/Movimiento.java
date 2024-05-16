package model;

import java.time.LocalDateTime;
/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//*/
public class Movimiento {

	private int idMovimiento;
	private int idCuenta;
	private LocalDateTime fecha;
	private double cantidad;
	private String operacion;
	
	public Movimiento() {}

	public Movimiento(int idMovimiento, int idCuenta, LocalDateTime fecha, double cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	

} 