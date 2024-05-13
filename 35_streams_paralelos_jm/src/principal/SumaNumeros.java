package principal;

import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.LongStream;

public class SumaNumeros {

	public static void main(String[] args) {
		LocalTime lt1 = LocalTime.now();
		System.out.println(LongStream.rangeClosed(1, 60_000_000_000L)
				.parallel()
				.sum());
	
	LocalTime lt2 = LocalTime.now();
	Duration p = Duration.between(lt1, lt2);
	System.out.println(p);
	}	
}

