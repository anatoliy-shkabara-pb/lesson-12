package s04jdkfunction;

import java.util.function.Function;

public class Main2Function {
    public static void main(String[] args) {
        Function<Double, Long> function = d -> Math.round(d);
        System.out.println(function.apply(5.7));

        // методы compose и andThen
        Function<String, String> f1 = s -> s + "1";
        Function<String, String> f2 = s -> s + "2";
        Function<String, String> f3 = s -> s + "3";
        Function<String, String> f4 = s -> s + "4";
        System.out.println(f1.compose(f2).compose(f3).compose(f4).apply("Compose"));
        System.out.println(f1.andThen(f2).andThen(f3).andThen(f4).apply("AndThen"));

        // метод identity() возвращает интерфейс Function, который всегда возвращает входной параметр.
        Function<String, String> f = Function.identity();
        System.out.println(f.apply("Some Value"));
    }
}
