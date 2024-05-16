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
public class Provincia {
	@SerializedName("CODPROV")
	private String codigoProvincia;
	@SerializedName("NOMBRE_PROVINCIA")
	private String nombreProvincia;
	@SerializedName("COMUNIDAD_CIUDAD_AUTONOMA")
	private String comunidadAutonoma;
	
	//*
	
	public Provincia() {
		super();
	}

	public Provincia(String codigoProvincia, String nombreProvincia, String comunidadAutonoma) {
		super();
		this.codigoProvincia = codigoProvincia;
		this.nombreProvincia = nombreProvincia;
		this.comunidadAutonoma = comunidadAutonoma;
	}

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
	
	
	//*/
}
