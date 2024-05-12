package methodRef;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodRefMain {
	public static void main(String[] args) {
		MethodRefClass methodRefClass = new MethodRefClass();

		// static 메서드 사용
		UnaryOperator<String> hi = MethodRefClass::sayHi;

		// 인스턴스 메서드 사용
		UnaryOperator<String> hello = methodRefClass::sayHello;

		// 생성자 참조
		Supplier<MethodRefClass> supplier = MethodRefClass::new;
		Function<String, MethodRefClass> function = MethodRefClass::new;

		// 임의 객체의 인스턴스 메서드 참조

		String[] names = {"paul", "abc", "zira"};
		Arrays.sort(names, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(names));
	}
}
