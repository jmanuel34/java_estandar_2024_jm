package model;

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
	
	public Municipio() {
		super();
	}

	public Municipio(String nombreMunicipio, String nombreProvincia, String poblacion) {
		super();
		this.nombreMunicipio = nombreMunicipio;
		this.nombreProvincia = nombreProvincia;
		this.poblacion = poblacion;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
}
