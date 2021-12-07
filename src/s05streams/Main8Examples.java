package s05streams;

import java.util.stream.IntStream;

public class Main8Examples {
    public static void main(String[] args1) {
        // Вывести таблицу умножения.
        IntStream.rangeClosed(2, 9)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(2, 9)
                        .mapToObj(j -> String.format("%d * %d = %d", i, j, i * j))
                )
                .forEach(System.out::println);
    }
}
