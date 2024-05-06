package model;

import com.google.gson.annotations.SerializedName;

public class Municipio {
	
	@SerializedName("CODIGOINE")
	private String codigoINE;
	@SerializedName("CODPROV")
	private String codigoProvincia;
	@SerializedName("NOMBRE")
	private String nombreMunicipio;
	@SerializedName("NOMBRE_PROVINCIA")
	private String nombreProvincia;
	@SerializedName("POBLACION_CAPITAL")
	private String poblacion;
	@SerializedName("NOMBRE_CAPITAL")
	private String nombreCapital;
	@SerializedName("POBLACION_MUNI")
	private String poblacionMuni;
	@SerializedName("LONGITUD_ETRS89_REGCAN95")
	private String longitud;
	@SerializedName("LATITUD_ETRS89_REGCAN95")
	private String latitud;
	@SerializedName("ALTITUD")
	private int altitud;
	@SerializedName("SUPERFICIE")
	private Double superficie;
	
	public Municipio() {
		super();
	}

	public Municipio(String codigoINE, String codigoProvincia, String nombreMunicipio, String nombreProvincia,
			String poblacion, String nombreCapital, String poblacionMuni, String longitud, String latitud, int altitud,
			Double superficie) {
		super();
		this.codigoINE = codigoINE;
		this.codigoProvincia = codigoProvincia;
		this.nombreMunicipio = nombreMunicipio;
		this.nombreProvincia = nombreProvincia;
		this.poblacion = poblacion;
		this.nombreCapital = nombreCapital;
		this.poblacionMuni = poblacionMuni;
		this.longitud = longitud;
		this.latitud = latitud;
		this.altitud = altitud;
		this.superficie = superficie;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getCodigoINE() {
		return codigoINE;
	}

	public void setCodigoINE(String codigoINE) {
		this.codigoINE = codigoINE;
	}

	public void setAltitud(int altitud) {
		this.altitud = altitud;
	}

	public String getNombreCapital() {
		return nombreCapital;
	}

	public void setNombreCapital(String nombreCapital) {
		this.nombreCapital = nombreCapital;
	}

	public String getPoblacionMuni() {
		return poblacionMuni;
	}

	public void setPoblacionMuni(String poblacionMuni) {
		this.poblacionMuni = poblacionMuni;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public int getAltitud() {
		return altitud;
	}

	public void setAltura(int altitud) {
		this.altitud = altitud;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
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

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
}
