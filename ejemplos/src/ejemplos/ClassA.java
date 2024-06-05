package ejemplos;

public class ClassA {
		ClassA(){				// Constructor
				System.out.println("A");
			}
			ClassA(int n){			// Constructor con parámetro
				System.out.println("2A");
			}

	public static void main (String [] args) {
//		ClassA a=new ClassA(10); //AB
		B b = new B(10);
	}

}
class B extends ClassA{
	B(){}
	B(int x){
		this(x);
		System.out.println("B");
	}
}
