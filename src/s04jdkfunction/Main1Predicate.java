package s04jdkfunction;

import java.util.function.Predicate;

public class Main1Predicate {
    public static void main(String[] args) {
        // Predicate для нахождения отрицательных чисел:
        Predicate<Integer> negative = i -> i < 0;
        System.out.println(negative.test(-6));
        System.out.println(negative.test(6));
        System.out.println(negative.test(0));

        // метод and() интерфейса Predicate
        Predicate<String> containsA = t -> t.contains("A");
        Predicate<String> containsB = t -> t.contains("B");
        boolean result = containsA.and(containsB).test("ABCD");
        System.out.println(result);
    }
}
