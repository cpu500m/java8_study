package dateAndTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OldDateMain {
	public static void main(String[] args) throws InterruptedException {
		/* Java 8 이전에 사용하던 날짜 관련 클래스 */
		// 일단 굉장히 직관적이지 못함. getTime() 으로 꺼냈는데 1592868488458 이런 알 수 없는 값이 나옴.
		Date date = new Date();
		long time = date.getTime();
		System.out.println(date);
		System.out.println(time);

		// mutable 하므로 thread safe하지 못함. 기존 객체가 수정이 가능함.
		Thread.sleep(1000 * 3);
		Date after3Seconds = new Date();
		System.out.println(after3Seconds);
		after3Seconds.setTime(time);
		System.out.println(after3Seconds);

		// GregorianCalendar만들 때 두번쨰 받는 인자값이 type safe하지 못함. int 타입을 받는데 실제로는 0~11 만 유효.
		Calendar myBirthday = new GregorianCalendar(1999, Calendar.FEBRUARY, 25);
		myBirthday.add(Calendar.DATE, 1);
		System.out.println(myBirthday.getTime());

	}
}
