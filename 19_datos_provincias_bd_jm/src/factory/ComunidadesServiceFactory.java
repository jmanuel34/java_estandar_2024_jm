package factory;

import dao.ComunidadesDao;
import dao.ComunidadesDaoImpl;

public class ComunidadesServiceFactory {

	public static ComunidadesDao getComunidadesDao() {
		return new ComunidadesDaoImpl();
	}
}
