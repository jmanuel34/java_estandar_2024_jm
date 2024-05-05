package model;
/*
 * Realizar una aplicación que muestre el nombre de cada comunidad autónoma, 
 * y para cada una
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

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Provincia {
	public Provincia(String codigoProvincia, String nombreProvincia, String comunidadAutonoma) {
		super();
		this.codigoProvincia = codigoProvincia;
		this.nombreProvincia = nombreProvincia;
		this.comunidadAutonoma = comunidadAutonoma;
	}
	public Provincia() {
		super();
	}
	@SerializedName("CODPROV")
	private String codigoProvincia;
	@SerializedName("NOMBRE_PROVINCIA")
	private String nombreProvincia;
	@SerializedName("COMUNIDAD_CIUDAD_AUTONOMA")
	private String comunidadAutonoma;
	public String getCodigoProvincia() {
		return codigoProvincia;
	}
	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}
	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}
	
}
