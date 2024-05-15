package service;

public class DatosServiceFactory {
	public static DatosProvinciasService getDatosProvincias() {
		return new DatosProvinciasServiceImpl();
	}

}
