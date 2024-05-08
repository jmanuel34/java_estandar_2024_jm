package model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {
	private int idPedido;
	private String producto;
	private String tienda;
//	private LocalDateTime fecha;
	private double precio;

}
