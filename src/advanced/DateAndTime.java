package advanced;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.swing.plaf.SliderUI;

public class DateAndTime {
	public static void main(String[] args) {
		// Instant is a point on the time line
		System.out.println(Instant.MAX);
		System.out.println(Instant.MIN);
		Instant now = Instant.now();
		System.out.println(now);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant end = Instant.now();
		
		//  Duration is time ellapsed
		System.out.println(Duration.between(now, end).toMillis());
		
		Duration duration = Duration.between(now, end);
		System.out.println(duration.plusMillis(1500).toMillis());
		
		// Local Date
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalDate date2 = LocalDate.of(1995, Month.JANUARY, 20);
		System.out.println(date2);
		
		// Period: amount time between to date
		Period period = Period.between(date2, date);
		System.out.println(period.getYears());
		Period p = date2.until(LocalDate.now());
		System.out.println(p.getYears());
		
		// LocalTime
		LocalTime midnight = LocalTime.MIDNIGHT;
		System.out.println(midnight);
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		LocalTime lt2 = LocalTime.of(10, 20); // 10:20
		System.out.println(lt2);
		
		// Zone time
		Set<String> allZonesId = ZoneId.getAvailableZoneIds();
		System.out.println(allZonesId);
		ZonedDateTime currentMeeting = ZonedDateTime.of(
				LocalDate.of(2017, 7, 20),
				LocalTime.of(8, 20),
				ZoneId.of("Asia/Ho_Chi_Minh"));
		
		ZonedDateTime nextMeeting = currentMeeting.plusMonths(1);
				
		ZonedDateTime nextMeetingUs = nextMeeting.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
		
		System.out.println(nextMeetingUs.getHour());
		
		// Datetime formatter
		System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(nextMeeting));
	}
}
