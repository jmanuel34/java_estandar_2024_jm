package ejemplos;

	class classX{
		classX(int r){
			System.out.println("2X");
		}
	}

	class A extends classX{
		A(){  //error de compilación
			System.out.println("A");
		}
		A(int n){ //error de compilación
			System.out.println("2A");
		}
	}
	class B extends A{
		B(){super(2);}
		B(int x){
			this();
			System.out.println("B");
		}
	}

	B b=new B(10);

}
