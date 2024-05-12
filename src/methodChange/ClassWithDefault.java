package methodChange;

public record ClassWithDefault(String name) implements InterfaceWithDefault, ConflictDefaultInterface {

	@Override
	public void printName() {
		System.out.println(this.name);
	}

	// 아래처럼 충돌 난 함수를 재정의해줘야함. 안그러면 에러임.
	@Override
	public void printNameUpperCase() {
		InterfaceWithDefault.super.printNameUpperCase();
	}

}
