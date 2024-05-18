package annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 이렇게 Target으로 TYPE_USE를 설정하면 타입이 있는 곳 어디에나 붙일 수 있음.
@Chicken("앙념")
@Chicken("간장")
public class AnnotationMain {
	public static void main(String[] args) throws RuntimeException {

		// 배열로 가져오는 방법
		Chicken[] chickens = AnnotationMain.class.getAnnotationsByType(Chicken.class);
		Arrays.stream(chickens).forEach(c -> {
			System.out.println(c.value());
		});

		// 컨테이너 타입으로 가져오는 방법
		ChickenContainer chickenContainer = AnnotationMain.class.getAnnotation(ChickenContainer.class);
		Arrays.stream(chickenContainer.value()).forEach(c -> {
			System.out.println(c.value());
		});
	}
}
