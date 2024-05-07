package dao;

import java.util.List;

import model.Municipio;

public interface MunicipiosDao {
	boolean existeMunicipio(Municipio municipio);
	void saveMunicipios(List<Municipio> municipios);
	List<String> findCodigos();

}
