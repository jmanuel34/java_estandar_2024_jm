package principal;

import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		// Muestra los positivos no duplicados
		List<Integer> nums = List.of(5,11,4,-22,3,11,5,9,4, -3,3,-8);
		nums.stream()
			.distinct()
			.filter (n->n>0)
			.sequential()
//			.forEach (System.out::println);
			.forEach(n->System.out.println(n));
	}

}
