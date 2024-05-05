package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonProvincia {
	public JsonProvincia(List<Provincia> provincias) {
		super();
		this.provincias = provincias;
	}

	public JsonProvincia() {
		super();
	}

	private List<Provincia> provincias;

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
}
