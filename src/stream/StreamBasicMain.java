package stream;

import java.util.ArrayList;
import java.util.List;

public class StreamBasicMain {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("John");
		names.add("zabd");
		names.add("paul");
		names.add("abc1");

		// stream()이 있고 parallelStream()이 있음.
		// parallelStream 같은 경우는 여러 스레드에서 병렬적으로 데이터를 처리.
		// 근데 병렬처리한다고 무조건 빨라지는게 아님.
		// 스레드를 만들고, 스레드 작업완료하면 가비지컬렉션해야하고, 스레드 context switching 해야하고..
		// 그래서 오버헤드 비용을 뛰어넘을 만큼 데이터의 크기가 클 때 유용한거임.
		List<String> list = names.parallelStream().map(s -> {
				System.out.println(s + " " + Thread.currentThread().getName());
				return s.toUpperCase();
			})
			.toList();
		list.forEach(System.out::println);
	}
}
