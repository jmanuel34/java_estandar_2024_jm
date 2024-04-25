package exceptions;

import javax.management.RuntimeErrorException;

public class ErrorDatosException extends RuntimeException  {
	@Override
	public String getMessage() {
		return ("No existen datos"); 
	}
}
