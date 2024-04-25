package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Implementar lógica de negocio de una aplicación que proporcione información
 * sobre paises. Cada pais se caracteriza por: nombre,continente,capital,habitantes
 * 
 * -Lista de continentes
 * -Lista de paises a partir del continente
 * -Pais más poblado 
 * -Tabla con paises agurpados por continente
 * -Pais a partir de su capital  
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pais {
	@SerializedName(value="name")
	private String nombre;
	private String capital;
	@SerializedName(value="region")	
	private String continente;
	@SerializedName(value="population")
	private int habitantes;

}
