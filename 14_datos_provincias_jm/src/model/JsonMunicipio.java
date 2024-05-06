package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class JsonMunicipio {
	public JsonMunicipio(List<Municipio> municipios) {
		super();
		this.municipios = municipios;
	}

	public JsonMunicipio() {
		super();
	}

	public List<Municipio> municipios;

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
}
