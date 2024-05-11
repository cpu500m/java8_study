package functionalInterface;

@FunctionalInterface
public interface FunInterface {
    void abstractMethod(int arg1);
    static void sayHi(){
        System.out.println("Hi");
    }
    default void sayHello(){
        System.out.println("Hello");
    }
}
