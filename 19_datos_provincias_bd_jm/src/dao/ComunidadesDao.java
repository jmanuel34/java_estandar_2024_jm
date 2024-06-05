package dao;

/* Salva la lista de Comunidades, evitando guardar por segunda vez comunidades
 * que ya estén en la base de datos.
 * Devuelve como resultado el total de Comunidades guardadas.
 * Lo mismo para provincias y municipios
 * 
 */
import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;

public interface ComunidadesDao {

	int saveComunidades(List<Comunidad> comunidades);
	boolean existeComunidad(String codigo);
	boolean saveComunidad (Comunidad comunidad);
	public void borrarComunidades();
	
	static ComunidadesDao of() {
		return new ComunidadesDaoImpl();
		
	}
	// Codigo de pruebas
//	int print(); 
}