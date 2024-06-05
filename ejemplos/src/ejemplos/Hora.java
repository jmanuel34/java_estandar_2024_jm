package ejemplos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
// Acojonante con las 0 y la 1:00. Solo suma 1 o no suma con plusHour
public class Hora {

	public static void main(String[] args) {
		
		
		
		ZoneId zoneid= ZoneId.of("America/Chicago");
		ZonedDateTime zdt= ZonedDateTime.of(LocalDate.of(2021, 11, 07), LocalTime.of(2,30), zoneid);
		System.out.println(zdt.getHour());
		
		ZonedDateTime anHourLater = zdt.plusHours(2);
		System.out.println(zdt.getHour() == anHourLater.getHour());
		System.out.println(anHourLater.getHour());

	}

}
