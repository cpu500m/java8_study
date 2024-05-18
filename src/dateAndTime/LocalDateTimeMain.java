package dateAndTime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeMain {
	public static void main(String[] args) {
		useFormatting();
	}

	public static void useLocalDateTime() {
		// local 정보로 시간을 표기함. 이를 유의해야함.
		// 서버가 어디있냐에 따라 시간이 달라지는거지
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(nowInKorea);
	}

	public static void useZonedDateTime() {
		ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(nowInKorea);

	}

	// human 시간을 비교할 때는 period를 사용
	public static void useLocalDate() {
		LocalDate today = LocalDate.now();
		LocalDate targetDay = LocalDate.of(2024, Month.MAY, 24);

		Period period = Period.between(today, targetDay);
		System.out.println(period.getDays());

		Period until = today.until(targetDay);
		System.out.println(period.get(ChronoUnit.DAYS));
	}

	// machine time을 비교할 때는 duration
	public static void useDuration() {
		Instant now = Instant.now();
		Instant plus = now.plus(10, ChronoUnit.SECONDS);
		Duration between = Duration.between(now, plus);
		System.out.println(between.getSeconds());
	}

	// formatting & parsing
	public static void useFormatting() {
		// formatting. 이렇게 포맷을 정의할 수도 있지만 이미 정의 돼 있다면 뭐 그냥 갖다써
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(now.format(MMddyyyy));

		// parsing
		LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
		System.out.println(parse);

	}
}
