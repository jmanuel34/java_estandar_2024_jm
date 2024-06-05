package ejemplos;

public class EjemploAnd {

	public static void main(String[] args) {
		Object ob="hello";
		if(ob instanceof String s||s.length()>4){ //error compilación. Con un && sí compila
			System.out.println("superado");
		}else{
			System.out.println("no válido");
		}
	}

}

}
