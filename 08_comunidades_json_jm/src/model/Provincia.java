package model;

import com.google.gson.annotations.SerializedName;

/*
* Realizar una aplicación que muestre el nombre de cada comunidad autónoma, y para cada una
 * mostrará sus provincias y dentro de esta, sus municipios.
 * Datos de cada tipo de objeto:
 * -provincia: nombre, codigo, comunidad
 * -municipio: nombre, provincia, poblacion 
 */
public class Provincia {
	@SerializedName("CODPROV")
	private String codigoProvincia;
	@SerializedName("NOMBRE_PROVINCIA")
	private String nombreProvincia;
	@SerializedName("COMUNIDAD_CIUDAD_AUTONOMA")
	private String comunidadAutonoma;
} 

}
