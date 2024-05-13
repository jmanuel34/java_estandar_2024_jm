package principal;

import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> nums = List.of(5,11,4,22,3,11,5,9,4);
		System.out.println(nums.parallelStream()
//		System.out.println(nums.stream()
//		.parallel()
		.distinct()
		.count()
		);
		
	}

}
