package exceptions;

public class ErrorFuenteDatosException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return ("No se pudo acceder al fichero de notas"); 
	}

}
