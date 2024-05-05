package principal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class TestCase {

	public static void main(String[] args) {
		/*
		int p=5;
		switch (p) {
			case 10: System.out.println("Es 10");
			case 2: System.out.println("Este es el 2");
			default: System.out.println("Este es el default");
			
			case 3: System.out.println("Este es el 3");
			int vals[]={3,6,9};
			for (int n:vals) System.out.println(n);
		}

	String n1="Esto";
	String n2="aquello";
	n1= n1.concat(n2);
	System.out.println(n1);
	System.out.println(n1.replace("to", "ca"));
	System.out.println(n1);
	
	StringBuilder sb=new StringBuilder("mutable");
	StringBuilder sb2 = sb.append("Test");
	StringBuilder sb3 = sb.append("nueva");
	System.out.println(sb3); //llamada a toString(), muestra: mutable nueva
	System.out.println(sb==sb3); //muestra true, apuntan al mismo objeto
//*/
		//*
		HashMap<Integer,String> tabla=new HashMap<>();
		tabla.put(200, "dato1");
		tabla.put(400, "dato2");
		tabla.put(200, "dato3");
		//*/
		
		Collection<String> datos=tabla.values();
		for(String s:datos){
			System.out.println(s); //muestra cada elemento
		}
		Set<Integer> claves= tabla.keySet();
		for (int s:claves) {
			System.out.println(s);
		}
	}
}
