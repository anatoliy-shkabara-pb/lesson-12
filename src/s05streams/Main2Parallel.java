package s05streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main2Parallel {
    public static void main(String[] args) {

        int sum = IntStream.range(0, 10)
                .parallel()
                .map(x -> x * 10)
                .sum();
        System.out.println("sum = " + sum);


        // Это код Шрёдингера. (Так делать нельзя)
        // Он может нормально выполниться и показать 1000000, может выполниться и показать 869877,
        // а может и упасть с ошибкой Exception in thread "main"
        // java.lang.ArrayIndexOutOfBoundsException: 332 at java.util.ArrayList.add(ArrayList.java:459)
        final List<Integer> ints = new ArrayList<>(); // нужно использовать CopyOnWriteArrayList
        IntStream.range(0, 10000)
                .parallel()
                .forEach(i -> ints.add(i));
        System.out.println("size = " + ints.size());
    }
}
