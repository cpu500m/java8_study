package functionalInterface;

import java.util.function.*;

public class FunInterfaceEx {
    public void useMyFunctionalInterface() {
        int val = 5;
        FunInterface ex = (int arg1) -> System.out.println(String.valueOf(arg1 + val));
        // 아래를 람다 표현식을 사용해서 위처럼 줄일 수 있음
        /*
        FunInterface ex1 = new FunInterface() {
            @Override
            public void abstractMethod(int arg1) {
                System.out.println(String.valueOf(arg1+3));
            }
        };
        */
        ex.abstractMethod(3);
        ex.abstractMethod(3);
    }

    public void useFunction(){
        int val = 5;
        Function<Integer,Integer> mainFunc = input -> input + val;
        Function<Integer,Integer> composeFunc = input -> input * 2;
        Function<Integer,Integer> andThenFunc = input -> input * 4;
        mainFunc = mainFunc.compose(composeFunc);
        mainFunc = mainFunc.andThen(andThenFunc);

        // 결과는 ((10*2) + 5 ) * 4 라서 100이 나와야함
        Integer result = mainFunc.apply(10);
        System.out.println("result = " + result);
    }

    // Function 과 제공하는 메서드는 똑같음. 차이점은 입력과 리턴의 타입이 같다는 것
    public void useUnaryOperator() {
        UnaryOperator<Integer> unaryOperator = input -> input * 2;

        Integer result = unaryOperator.apply(10);
        System.out.println("result = " + result);
    }

    public void useBiFunction(){
        int age = 9;
        BiFunction<String,Integer,String> biFunc = (String str, Integer val) -> str+val;
        String result = biFunc.apply("hello my age is ", age);
        System.out.println(result);
    }

    public void useBinaryOperator(){
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        Integer result = binaryOperator.apply(3, 5);
        System.out.println("result = " + result);

        // static 메서드 . minBy와 maxBy 있음
        BinaryOperator<Student> studentBinaryOperator = BinaryOperator.maxBy((s1, s2) -> s2.age- s1.age);
        Student minAgeStudent = studentBinaryOperator.apply(new Student("old", 33), new Student("young", 21));
        System.out.println("가장 어린 학생 정보: "+minAgeStudent);
    }

    public void useConsumer(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello!");
    }
    public void useSupplier(){
        Supplier<Integer> supplier = () -> 20;
        System.out.println(supplier.get());
    }
    public void usePredicate(){
        Predicate<String> checkMain = input -> input.startsWith("ap");
        Predicate<String> checkEnd = input -> input.endsWith("le");
        checkMain = checkMain.and(checkEnd);
        boolean result = checkMain.test("apple");
        System.out.println("expected result = true . result : " + result);
        result = checkMain.negate().test("apple");
        System.out.println("expected result = false . result : " + result);

        // static 메서드인 isEqual. 기존 객체와 같은 객체인지를 판별한다. (Object.equals()를 돌리는거임)
        Predicate<Object> studentPredicate = Predicate.isEqual(new Student("a",22));
        result = studentPredicate.test(new Student("a",22));
        System.out.println("expected result = false . result : " + result);
    }
}
