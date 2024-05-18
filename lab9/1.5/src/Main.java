// Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
// Задана коллекция строк. Вернуть список из коллекции без повторов.

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> array = List.of("one", "two", "one", "three", "one", "five", "four", "four", "five");
        System.out.println(Arrays.toString(array.stream().distinct().toArray()));
    }
}