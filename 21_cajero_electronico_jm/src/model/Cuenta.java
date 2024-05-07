package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Data
public class Cuenta {
	public Cuenta(int numeroCuenta, double saldo, String tipoCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}
	private int numeroCuenta;
	private double saldo;
	private String tipoCuenta;
}
