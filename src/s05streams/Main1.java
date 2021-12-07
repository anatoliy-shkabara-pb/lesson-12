package s05streams;

import java.util.stream.IntStream;

public class Main1 {
    public static void main(String[] args) {
        // Здесь уже три промежуточных оператора:
        // filter — отбирает элементы, значение которых меньше 300,
        // map — прибавляет 11 к каждому числу,
        // limit — ограничивает количество элементов до 3.
        // Терминальный оператор forEach применяет функцию print к каждому приходящему элементу.
        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

        // тот же пример без использования Stream API
        System.out.println("-------------------------------------");
        int[] arr = {120, 410, 85, 32, 314, 12};
        int count = 0;
        for (int x : arr) {
            if (x >= 300) continue;
            x += 11;
            count++;
            if (count > 3) break;
            System.out.println(x);
        }
    }
}
