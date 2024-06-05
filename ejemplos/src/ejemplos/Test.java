package ejemplos;

public class Test {

	public static void main(String[] args) {
		String s1="hello";
		String s2=" by";
		System.out.println(switch(s1.concat(s2)){
			case "hello"->s1.length();
			case "hello by"->s2.length();
			default->0;
		});
	}

}
