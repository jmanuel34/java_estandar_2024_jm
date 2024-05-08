package service;

public class CajeroServiceFactoy {
	
	public static CajeroService getCajeroService() {
		return new CajeroServiceImpl();
	}

}
