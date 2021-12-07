package s05streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main5Collectors {
    public static void main(String[] args) {
        // Собирает элементы в заданную коллекцию.
        Deque<Integer> deque = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println("deque: " + deque);

        Set<Integer> set = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("set: " + set);

        // Собирает элементы в Map.
        // Каждый элемент преобразовывается в ключ и в значение, основываясь на результате функций keyMapper
        // и valueMapper соответственно.
        // Если нужно вернуть тот же элемент, что и пришел, то можно передать Function.identity()

        Map<Integer, Integer> map1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        Function.identity(),
                        Function.identity()
                ));
        System.out.println("map1: " + map1);

        Map<Integer, String> map2 = Stream.of(1, 2, 3)
                .collect(Collectors.toMap(
                        Function.identity(),
                        i -> String.format("%d * 2 = %d", i, i * 2)
                ));
        System.out.println("map2: " + map2);

        Map<Character, String> map3 = Stream.of(50, 54, 55)
                .collect(Collectors.toMap(
                        i -> (char) i.intValue(),
                        i -> String.format("<%d>", i)
                ));
        System.out.println("map3: " + map3);

        // в случае, когда встречается два одинаковых ключа, позволяет объединить значения.
        Map<Integer, String> map4 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join("-", a, b)
                ));
        System.out.println("map4: " + map4);

        // позволяет указывать, какой именно класс Map использовать.
        Map<Integer, String> map5 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join(", ", a, b),
                        LinkedHashMap::new
                ));
        System.out.println("map5: " + map5);

        // collectingAndThen(Collector downstream, Function finisher)
        // Собирает элементы с помощью указанного коллектора, а потом применяет к полученному результату функцию.
        List<String> list = Stream.of("a", "b", "c", "d")
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Function.identity(), s -> s + s),
                        map -> map.entrySet().stream()))
                .map(e -> e.toString())
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList));
        System.out.println("list: " + list);

        // counting() Подсчитывает количество элементов.
        Long count = Stream.of("1", "2", "3", "4")
                .collect(Collectors.counting());
        System.out.println("count: " + count);

        // minBy(Comparator comparator)
        // maxBy(Comparator comparator)
        // Поиск минимального/максимального элемента, основываясь на заданном компараторе.
        Optional<String> min = Stream.of("ab", "c", "defgh", "ijk", "l")
                .collect(Collectors.minBy(Comparator.comparing(String::length)));
        min.ifPresent(mi -> System.out.println("min: " + mi));

        Optional<String> max = Stream.of("ab", "c", "defgh", "ijk", "l")
                .collect(Collectors.maxBy(Comparator.comparing(String::length)));
        max.ifPresent(ma -> System.out.println("max: " + ma));

        // Группировка элементов
        Map<Integer, List<String>> gmap1 = Stream.of(
                        "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.groupingBy(String::length));
        System.out.println("gmap1: " + gmap1);

        Map<Integer, String> gmap2 = Stream.of(
                        "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.joining())
                ));
        System.out.println("gmap2: " + gmap2);

        Map<Integer, List<String>> gmap3 = Stream.of(
                        "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.groupingBy(
                        String::length,
                        LinkedHashMap::new,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.toList())
                ));
        System.out.println("gmap3: " + gmap3);

        // partitioningBy(Predicate predicate)
        // partitioningBy(Predicate predicate, Collector downstream)
        // Разбивает последовательность элементов по какому-либо критерию.
        // В одну часть попадают все элементы, которые удовлетворяют переданному условию,
        // во вторую — все, которые не удовлетворяют.
        Map<Boolean, List<String>> pmap1 = Stream.of(
                        "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.partitioningBy(s -> s.length() <= 2));
        System.out.println("pmap1: " + pmap1);

        Map<Boolean, String> pmap2 = Stream.of(
                        "ab", "c", "def", "gh", "ijk", "l", "mnop")
                .collect(Collectors.partitioningBy(
                        s -> s.length() <= 2,
                        Collectors.mapping(
                                String::toUpperCase,
                                Collectors.joining())
                ));
        System.out.println("pmap2: " + pmap2);

    }
}
