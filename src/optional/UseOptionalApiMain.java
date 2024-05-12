package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UseOptionalApiMain {
	public static void main(String[] args) {
		List<OnlineClass2> list = new ArrayList<>();
		list.add(new OnlineClass2(1, "spring", true));
		list.add(new OnlineClass2(5, "rest api development", false));

		// 1. 값이 있는 경우
		Optional<OnlineClass2> spring = list.stream()
			.filter(oc -> oc.getTitle().startsWith("spring"))
			.findFirst();

		boolean present = spring.isPresent();
		System.out.println(present);

		// 2. 값이 없는 경우
		Optional<OnlineClass2> optional = list.stream()
			.filter(oc -> oc.getTitle().startsWith("jpa"))
			.findFirst();

		optional.ifPresent(oc -> System.out.println(oc.getTitle()));

		// - 값 꺼내기
		// 이미 만들어져 있는 게 있다면 orElse를 쓰고, 동적으로 만들어야한다면 orElseGet을 쓰는게 좋을것 같다하심
		/*optional.orElseGet(() -> new OnlineClass2(1, "spring", true));
		 */
		// - 값이 없다면 예외 던지기
/*
		optional.orElseThrow(IllegalStateException::new);
*/

		// Optional 에 필터를 적용할 수도 있음.
/*
		Optional<OnlineClass2> emptyExpected = spring.filter(oc -> oc.getId() > 10);
		System.out.println(emptyExpected.isEmpty());
*/

		// map도 적용가능
		/*
		Optional<Integer> springId = spring.map(OnlineClass2::getId);
		System.out.println(springId.isPresent());
		*/

		// 만약 map에서 꺼낸값이 또 Optional 인경우 flatMap 사용.
/*
		// 위와 아래는 같은 코드.
		Optional<Progress> progress = spring.flatMap(OnlineClass2::getProgress);

		Optional<Optional<Progress>> progress = spring.map(OnlineClass2::getProgress);
		Optional<Progress> progress1 = progress.orElse(Optional.empty());

*/
		Optional<Progress> progress = spring.flatMap(OnlineClass2::getProgress);

	}
}
