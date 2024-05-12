package stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class JavaStreamMain {
	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		List<OnlineClass> javaClasses = new ArrayList<>();
		javaClasses.add(new OnlineClass(6, "The Java, Test", true));
		javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
		javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

		List<List<OnlineClass>> paulEvents = new ArrayList<>();
		paulEvents.add(springClasses);
		paulEvents.add(javaClasses);

		// filter 사용해보기
		System.out.println("===spring으로 시작하는 수업===");
		springClasses.stream()
			.filter(oc -> oc.getTitle().startsWith("spring"))
			.forEach(o -> System.out.println(o.getTitle()));

		System.out.println();

		System.out.println("===close 되지 않은 수업===");
		springClasses.stream()
			.filter(Predicate.not(OnlineClass::isClosed))
			.forEach(o -> System.out.println(o.getTitle()));

		System.out.println();

		// map 사용해보기
		System.out.println("===수업 이름만 모아서 스트림 만들기===");
		springClasses.stream()
			.map(OnlineClass::getTitle)
			.forEach(System.out::println);

		System.out.println();

		// list 를 flatten 시키기.
		// flatten 시킨다는 것은 컬렉션을 분해해서 내부 요소들을 꺼내는 작업이라고 할 수 있음.
		// 포장지 찢는 느낌이지
		System.out.println("===두 수업 목록에 들어있는 모든 수업 아이디 출력===");
		paulEvents.stream()
			.flatMap(Collection::stream)
			.map(OnlineClass::getId)
			.forEach(System.out::println);

		System.out.println();

		// Stream 을 생성하는법.
		// + Short Circuit 메서드인 skip() 과 limit.
		// skip(long n) : n개만큼 건너뛰겠다
		// limit(long maxSize) : 앞에서부터 maxSize개만 보겠다
		System.out.println("===10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만===");
		Stream.iterate(10, i -> i + 1)
			.skip(10)
			.limit(10)
			.forEach(System.out::println);

		System.out.println();

		System.out.println("===자바 수업 중에 Test가 들어있는 수업이 있는지 확인===");
		boolean test = javaClasses.stream()
			.anyMatch(oc -> oc.getTitle().contains("Test"));
		System.out.println(test);

		System.out.println();

		System.out.println("===스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기===");
		List<String> containSpringList = springClasses.stream()
			.map(OnlineClass::getTitle)
			.filter(s -> s.contains("spring"))
			.toList();

		containSpringList.forEach(System.out::println);
	}
}
