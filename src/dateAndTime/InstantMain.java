package dateAndTime;

// java.time.chrono.   Java 8 부터는 해당 경로 아래 많은 달력들을 지원. ( extensible)

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantMain {
	public static void main(String[] args) {
		// Instant. 디폴트는 기준시. (그리니치 시각)
		Instant instant = Instant.now();
		System.out.println(instant); // 기준시 UTC, GTM

		// 이렇게 현재 시스템에 설정된 곳을 기준으로 시각을 볼 수도 있음.
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println(zoneId);
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		System.out.println(zonedDateTime);

		// 이렇게 설정해서 볼 수 있음.
		System.out.println(instant.atZone(ZoneId.of("UTC")));
	}
}
