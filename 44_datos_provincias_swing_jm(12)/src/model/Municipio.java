package model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
@NoArgsConstructor
@AllArgsConstructor
@Data
//*/

public class Municipio {
	@SerializedName("NOMBRE")
	private String nombreMunicipio;
	@SerializedName("NOMBRE_PROVINCIA")
	private String nombreProvincia;
	@SerializedName("POBLACION_CAPITAL")
	private int poblacion;
	@SerializedName ("ALTITUD")
	private int altitud;
	@SerializedName ("SUPERFICIE")
	private double superficie;
	
	//*	
	public Municipio() {
		super();
	}

	public Municipio(String nombreMunicipio, String nombreProvincia, int poblacion, int altitud, double superficie) {
		super();
		this.nombreMunicipio = nombreMunicipio;
		this.nombreProvincia = nombreProvincia;
		this.poblacion = poblacion;
		this.altitud = altitud;
		this.superficie = superficie;
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

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public int getAltitud() {
		return altitud;
	}

	public void setAltitud(int altitud) {
		this.altitud = altitud;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	
	//*/
	
}
