package service;

public class TiendaServiceFactory {
	
	public static TiendaService getTiendaService() {
		return new TiendaServiceImpl();
	}

}
