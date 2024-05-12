package methodRef;

public class MethodRefClass {
	private String name;

	public MethodRefClass() {
	}

	public MethodRefClass(String name) {
	}

	public String sayHello(String name) {
		return "Hello " + name;
	}

	public static String sayHi(String name) {
		return "Hi " + name;
	}
}
