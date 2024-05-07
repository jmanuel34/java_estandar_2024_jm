package service;


import java.util.List;

import dao.ComunidadesDao;
import dao.ComunidadesDaoFactory;
import dao.MunicipiosDao;
import dao.ProvinciasDao;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

public class ComunidadesServiceImpl implements ComunidadesService {
	
	ComunidadesDao comunidadesDao;
	ProvinciasDao provinciasDao;
	MunicipiosDao municipiosDao;
	
	public ComunidadesServiceImpl() {
		comunidadesDao=ComunidadesDaoFactory.getComunidadesDao();
		provinciasDao=ComunidadesDaoFactory.getProvinciasDao();
		municipiosDao=ComunidadesDaoFactory.getMunicipiosDao();	
	}
	
	@Override
	public int saveComunidades(List<Comunidad> comunidades) {
		/*
		return (int)comunidades.stream()
				.filter(p->!comunidadesDao.existeComunidad(p.getCodigo()))
				.peek(c->comunidadesDao.saveComunidad(c))
				.count();
		//*/

		List<Comunidad> aux = comunidades.stream()
				.filter(p->!comunidadesDao.existeComunidad(p.getCodigo()))
				.toList();
		comunidadesDao.saveComunidades(aux);
		return aux.size();
		
		
	}

	@Override
	public boolean saveComunidad(Comunidad comunidad) {	
		
		if (comunidad.getCodigo()!=null  && comunidad.getNombre() !=null) {
			comunidadesDao.saveComunidad(comunidad);
			return true;
		}
		return false;
	
		
	}
	
	@Override
	public boolean existeComunidad(String codigo) {
		return comunidadesDao.existeComunidad(codigo);
	}
	
	@Override
	public void borrarComunidades() {
		comunidadesDao.borrarComunidades();
	}
	@Override
	public int saveProvincias(List<Provincia> provincias) {
		List<String> codigos = provinciasDao.findCodigos();
		List<Provincia> aux =provincias.stream()
			.filter(p->!codigos.contains(p.getCodigoProvincia())) 
			.toList();			
		 provinciasDao.saveProvincias(aux);
		 return aux.size();		
	}
	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		List<String> codigos = municipiosDao.findCodigos();
		List<Municipio> aux =municipios.stream()
			.filter(p->!codigos.contains(p.getCodigoProvincia())) 
			.toList();			
		 municipiosDao.saveMunicipios(aux);
		 return aux.size();
		
	}
	@Override
	public int poblacionTotalProvincia(String provincia) {
		return provinciasDao.poblacionTotalProvincia(provincia);
		
	}
}
