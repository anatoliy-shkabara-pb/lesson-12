package s04jdkfunction;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main5UnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<String> uo = s -> s.toUpperCase();
        System.out.println(uo.apply("Java 8"));

        Function<String, String> func = s -> s.toUpperCase();
        System.out.println(func.apply("Java 8"));
    }
}
