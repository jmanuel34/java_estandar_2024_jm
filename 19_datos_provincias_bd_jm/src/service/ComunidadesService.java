package service;

import java.util.List;

import dao.ComunidadesDao;
import dao.ComunidadesDaoImpl;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

public interface ComunidadesService {
	
	public int saveComunidades(List<Comunidad> comunidades);
	public boolean saveComunidad(Comunidad comunidad);
	public int saveMunicipios(List<Municipio> municipios);
	public int saveProvincias(List<Provincia> provincias);
	public boolean existeComunidad(String codigo);
	public void borrarComunidades();
	public int poblacionTotalProvincia(String provincia) ;
	
	static ComunidadesService of() {
		return new ComunidadesServiceImpl();
	}

}
