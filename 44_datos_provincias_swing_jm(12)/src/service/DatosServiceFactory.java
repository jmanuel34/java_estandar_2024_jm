package service;

public class DatosServiceFactory {
	public static DatosService getDatos() {
		return new DatosServiceImpl();
	}

}
