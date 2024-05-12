package functionalInterface;

public class FunInterfaceMain {
    static FunInterfaceEx fun = new FunInterfaceEx();
    public static void main(String[] args) {
//        useMyFunctionalInterface();
//        useFunction();
//        useUnaryOperator();
//        useBiFunction();
//        useBinaryOperator();
//        useConsumer();
//         useSupplier();
         usePredicate();
    }

    // 함수형 인터페이스를 한번 만들어서 써보기
    public static void useMyFunctionalInterface() {
        fun.useMyFunctionalInterface();
    }

    /* 아래부터는 자바에서 기본적으로 제공하는 함수형 인터페이스 */
    // Function<T, R>
    public static void useFunction(){
        fun.useFunction();
    }

    // UnaryOperator<T>
    public static void useUnaryOperator() {
        fun.useUnaryOperator();
    }
    // BiFunction<T, U, R>
    public static void useBiFunction(){
        fun.useBiFunction();
    }

    // BinaryOperator<T>
    public static void useBinaryOperator(){
        fun.useBinaryOperator();
    }
    // Consumer<T>
    public static void useConsumer(){
        fun.useConsumer();
    }
    // Supplier<T>
    public static void useSupplier(){
        fun.useSupplier();
    }
    public static void usePredicate(){
        fun.usePredicate();
    }
}
