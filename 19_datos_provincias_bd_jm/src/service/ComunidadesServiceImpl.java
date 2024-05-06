package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.ComunidadesDao;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

public class ComunidadesServiceImpl implements ComunidadesService {
	
	ComunidadesDao comunidadesDao;
	public ComunidadesServiceImpl() {
		comunidadesDao=ComunidadesDao.of();
	}
	
	@Override
	public int saveComunidades(List<Comunidad> comunidades) {
		if (comunidades !=null) {
			return comunidadesDao.saveComunidades(comunidades);
		}
		return 0;	
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
		
		return comunidadesDao.saveProvincias(provincias);
		
	}
	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		return comunidadesDao.saveMunicipios(municipios);
	}
	@Override
	public int poblacionTotalProvincia(String provincia) {
		return comunidadesDao.poblacionTotalProvincia(provincia);
		
	}
}
