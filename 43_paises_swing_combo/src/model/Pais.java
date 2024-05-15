package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@NoArgsConstructor
@AllArgsConstructor
@Data
//*/

public class Pais {
	@SerializedName("name")
	private String nombre;
	@SerializedName("region")
	private String continente;
	private String capital;
	@SerializedName("population")
	private long poblacion;

	public Pais() {}

	public Pais(String nombre, String continente, String capital, long poblacion) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.capital = capital;
		this.poblacion = poblacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public long getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(long poblacion) {
		this.poblacion = poblacion;
	}
	
	
}
