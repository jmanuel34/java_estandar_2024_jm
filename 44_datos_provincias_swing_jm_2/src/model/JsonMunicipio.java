package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
@NoArgsConstructor
@AllArgsConstructor
@Data
//*/
public class JsonMunicipio {
	public List<Municipio> municipios;

//*
	public JsonMunicipio() {
		super();
	}

	public JsonMunicipio(List<Municipio> municipios) {
		super();
		this.municipios = municipios;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
	

	
//*/	
}
