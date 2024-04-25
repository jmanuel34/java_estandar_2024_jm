package exceptions;

public class ErrorFuenteDatosException extends RuntimeException {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No existen datos";
	}
	
}
