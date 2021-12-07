package s05streams;

import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main4Terminal {
    public static void main(String[] args) {

        // Возвращает массив с элементами стрима.
        String[] elements = Stream.of("a", "b", "c", "d")
                .toArray(String[]::new);
        System.out.println(Arrays.toString(elements));

        // Поиск минимального/максимального элемента, основываясь на переданном компараторе
        int min = Stream.of(20, 11, 45, 78, 13)
                .min(Integer::compare).get();
        System.out.println("min: " + min);

        int max = Stream.of(20, 11, 45, 78, 13)
                .max(Integer::compare).get();
        System.out.println("max: " + max);

        // findAny() Возвращает первый попавшийся элемент стрима.
        // findFirst() Гарантированно возвращает первый элемент стрима, даже если стрим параллельный.
        // Если нужен любой элемент, то для параллельных стримов быстрее будет работать findAny().
        int anySeq = IntStream.range(4, 65536)
                .findAny()
                .getAsInt();
        System.out.println("any: " + anySeq);

        int firstSeq = IntStream.range(4, 65536)
                .findFirst()
                .getAsInt();
        System.out.println("first: " + firstSeq);

        int anyParallel = IntStream.range(4, 65536)
                .parallel()
                .findAny()
                .getAsInt();
        System.out.println("any parallel: " + anyParallel);

        int firstParallel = IntStream.range(4, 65536)
                .parallel()
                .findFirst()
                .getAsInt();
        System.out.println("first parallel: " + firstParallel);

        // allMatch(Predicate predicate) Возвращает true, если все элементы стрима удовлетворяют условию predicate
        boolean result = Stream.of(1, 2, 3, 4, 5)
                .allMatch(x -> x <= 7);
        System.out.println("all match1: " + result);

        boolean result2 = Stream.of(1, 2, 3, 4, 5)
                .allMatch(x -> x < 3);
        System.out.println("all match2: " + result2);

        // anyMatch(Predicate predicate) Возвращает true, если хотя бы один элемент стрима удовлетворяет условию predicate.
        boolean anyMatch = Stream.of(1, 2, 3, 4, 5)
                .anyMatch(x -> x == 3);
        System.out.println("any match1: " + anyMatch);

        boolean anyMatch2 = Stream.of(1, 2, 3, 4, 5)
                .anyMatch(x -> x == 8);
        System.out.println("any match2: " + anyMatch2);

        // sum() Возвращает сумму элементов примитивного стрима.
        long sum = LongStream.range(2, 16)
                .sum();
        System.out.println("sum: " + sum);

        // IntSummaryStatistics summaryStatistics()
        // Позволяет собрать статистику о числовой последовательности стрима, а именно:
        // количество элементов, их сумму, среднее арифметическое, минимальный и максимальный элемент.
        LongSummaryStatistics stats = LongStream.range(2, 16)
                .summaryStatistics();
        System.out.format("  count: %d%n", stats.getCount());
        System.out.format("    sum: %d%n", stats.getSum());
        System.out.format("average: %.1f%n", stats.getAverage());
        System.out.format("    min: %d%n", stats.getMin());
        System.out.format("    max: %d%n", stats.getMax());

    }
}
