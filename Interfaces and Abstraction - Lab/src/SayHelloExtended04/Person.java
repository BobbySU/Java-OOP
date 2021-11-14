package SayHelloExtended04;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}

