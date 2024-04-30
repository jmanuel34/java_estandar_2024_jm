package model;
/*
* Realizar una aplicación que muestre el nombre de cada comunidad autónoma, y para cada una
 * mostrará sus provincias y dentro de esta, sus municipios.
 * Datos de cada tipo de objeto:
 * -provincia: nombre, codigo, comunidad
 * -municipio: nombre, provincia, poblacion 
 * https://www.el-tiempo.net/api
 *  Volcar esto es una base de datos
 *  Comunidad: nombre y codigo
 *  Provincia: nombre y codigo
 *  Municipios: superficie, poblacion, altitud ... codigo_geo
 
 */
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Municipio {
	@SerializedName("NOMBRE")
	private String nombreMunicipio;
	@SerializedName("NOMBRE_PROVINCIA")
	private String nombreProvincia;
	@SerializedName("POBLACION_CAPITAL")
	private String poblacion;
} 