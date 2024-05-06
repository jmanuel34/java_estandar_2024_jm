package service;

public class CursosJSonFactory {
	public static CursosJSonService getCursosJsonService() {	
		return new CursosJsonServiceImpl();
	}

}
