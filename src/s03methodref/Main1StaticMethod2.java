package s03methodref;

import java.util.function.BiFunction;

public class Main1StaticMethod2 {

    static class Arithmetic {
        public static int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        execute(Arithmetic::add);
    }

    private static void execute(BiFunction<Integer, Integer, Integer> biFunction) {
        Integer result = biFunction.apply(10, 20);
        System.out.println(result);
    }
}
