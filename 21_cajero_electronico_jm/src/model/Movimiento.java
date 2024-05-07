package model;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movimiento {
	private int idMovimiento;
	private int idCuenta;
	private LocalDate fecha;
	private double cantidad;
	private String operacion;
}
