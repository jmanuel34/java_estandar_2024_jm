package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Empleado {
	@SerializedName(value="nombre")
	private String empleado;
	private String email;
	private double salario;
	private String departamento;
		
}
