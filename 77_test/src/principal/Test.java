package principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

interface I1{

}
class C1 implements I1{

}
class C2 extends C1{

}

 

public class Test {

	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<>();
		printHashcode((Object)array);
//		List<Integer> l = new HashSet<>();
		Object s="100";
		Integer r=(Integer)s;
		System.out.println(r);
	}
	static void printHashcode(Object ob){
		System.out.println(ob.hashCode());
	}

}
