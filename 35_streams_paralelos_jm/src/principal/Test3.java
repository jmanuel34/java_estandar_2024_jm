package principal;

import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		List<Integer> nums = List.of(5,11,4,22,3,11,5,9,4,30,34,23,17);
/*
		nums.stream()
		//		nums.parallelStream()
		.peek(System.out::println)
		.anyMatch(n->n>10);
//*/
		System.out.println(nums.stream()
			.anyMatch(n->n>10));
	}

}
