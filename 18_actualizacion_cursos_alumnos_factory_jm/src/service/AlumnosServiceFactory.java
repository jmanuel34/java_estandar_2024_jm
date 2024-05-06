package service;

public class AlumnosServiceFactory {
	
	public static AlumnosService getAlumnosService() {	
		return new AlumnosServiceImpl();
	}
}
