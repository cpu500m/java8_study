package methodChange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class StudyIterable {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("paul");
		names.add("baul2");
		names.add("zaul3");
		names.add("aaul4");
		names.add("Abdul5");

		// 아래와 같이 체이닝 방식으로 사용 가능.  다른 조건을 통해 추가적으로 정렬하고싶다면
		//compareToIgnoreCase.reversed().thenComparing(Function Or Comparator) 처럼 사용 가능
		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
		names.sort(compareToIgnoreCase.reversed());

		// 아래 두개 똑같은 거임
		// names.forEach(System.out::println);
		// names.forEach((str) -> System.out.println(str));

		// 자바8의 Iterable에 추가된 default 메서드인 spliterator()임.
		// 대표적으로 Collection의 stream() 함수 내부에서 사용된다.
		Spliterator<String> spliterator = names.spliterator();
		Spliterator<String> spliterator1 = spliterator.trySplit();
		while (spliterator.tryAdvance(System.out::println))
			;
		System.out.println("==============");
		while (spliterator1.tryAdvance(System.out::println))
			;

		// stream 맛보기
		List<String> list = names.stream().map(String::toUpperCase)
			.filter(s -> s.startsWith("A"))
			.toList();

		// removeIf도 Collection의 default 메서드임. 근데 ArrayList에서 Override 돼있긴함
		names.removeIf(s -> s.endsWith("4"));

		System.out.println("list = " + list);
	}
}
