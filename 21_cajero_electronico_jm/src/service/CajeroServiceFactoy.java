package service;

public class CajeroServiceFactoy {
	
	public CajeroService getCajeroService() {
		return new CajeroServiceImpl();
	}

}
