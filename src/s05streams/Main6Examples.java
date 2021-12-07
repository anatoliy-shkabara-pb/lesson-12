package s05streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main6Examples {
    public static void main(String[] args1) {
        // Бывают ситуации, когда красиво реализовать задачу с использованием Stream API не получается.
        // Дан массив аргументов. Нужно получить Map, где каждому ключу будет соответствовать своё значение.
        String[] arguments = {"-i", "in.txt", "--limit", "40", "-d", "1", "-o", "out.txt"};
        Map<String, String> argsMap = new LinkedHashMap<>(arguments.length / 2);
        for (int i = 0; i < arguments.length; i += 2) {
            argsMap.put(arguments[i], arguments[i + 1]);
        }
        argsMap.forEach((key, value) -> System.out.format("%s: %s%n", key, value));

        // обратная задача — сконвертировать Map с аргументами в массив строк лучше делать со стримами.
        String[] args = argsMap.entrySet().stream()
                .flatMap(e -> Stream.of(e.getKey(), e.getValue()))
                .toArray(String[]::new);
        System.out.println(String.join(" ", args));
    }
}
