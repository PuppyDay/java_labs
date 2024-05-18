// Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
// Задана коллекция строк. Преобразовать в MAP, где первый символ ключ, второй – значение.

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> array = List.of("one", "two", "one", "three", "one", "five", "four", "four", "five");
        System.out.println(array.stream().collect(Collectors.groupingBy(
                x -> x.charAt(0),
                Collectors.mapping(x -> x.charAt(1), Collectors.toSet())
        )));
    }
}