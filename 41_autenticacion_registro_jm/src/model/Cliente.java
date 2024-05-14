package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
	private int idCliente;
	private String usuario;
	private String password;
	private String email;
	private int telefono;

	public Cliente(String usuario, String password, String email, int telefono) {
		this.usuario=usuario;
		this.password=password;
		this.email=email;
		this.telefono= telefono;
	}
}