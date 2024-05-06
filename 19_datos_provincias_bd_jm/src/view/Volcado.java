package view;

import dao.ComunidadesDao;
import service.DatosProvinciasService;

public class Volcado {

	public static void main(String[] args) {
		var comService= ComunidadesDao.of();
		var provService=new DatosProvinciasService();
		comService.saveComunidades(provService.comunidades());
		comService.saveProvincias(provService.provincias());
		comService.saveMunicipios(provService.municipios());
		System.out.println("Volcado completado!!");

	}

}
