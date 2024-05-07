package dao;

import java.util.List;

import model.Comunidad;
import model.Provincia;

public interface ProvinciasDao {
	int saveProvincias(List<Provincia> provincias);
	int poblacionTotalProvincia(String provincia);
	List<String> findCodigos();


}
