package SayHello03;

public interface Person {
    String getName();

    default String sayHello(){
        return "Hello";
    }
}
