package ejemplos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Eje01 {

	public static void main(String[] args) {
/*	LocalDateTime ldt = LocalDateTime.of(LocalDate.now(), LocalTime.now());
	LocalDateTime ldt = LocalDateTime(2024,11,11 08,00,00));
	LocalTime ldt1=new LocalTime(10,30,45);
	LocalDate ld = LocalDate.of(2024, 11, 12);
//*/
		
		int [][] numbers= {{5,3,4,4,6},{4,2},{3,7,9,8}};
		System.out.println(numbers.length);
		Integer[] ages= {45,11,25};
		var lst1= Arrays.asList(ages);
		var lst2= List.of(ages);
		var lst3= List.copyOf(lst1);
		lst1.sort(Comparator.naturalOrder());
		System.out.println(lst2.get(0)+":"+lst3.get(ages.length-1));
		
	}

}
