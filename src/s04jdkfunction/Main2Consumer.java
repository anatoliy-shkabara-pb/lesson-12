package s04jdkfunction;

import java.util.function.Consumer;

public class Main2Consumer {
    public static void main(String[] args) {
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello");

        // использование метода andThen()
        Consumer<String> printLowerCase = str -> System.out.println(str.toLowerCase());
        printUpperCase.andThen(printLowerCase).accept("Hello world");
    }
}
