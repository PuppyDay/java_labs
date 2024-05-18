// Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
// Задана коллекция чисел. Разделить числа на четные и нечетные.

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> result = array.stream().collect(
                Collectors.partitioningBy(x -> x%2 == 0)
        );
        System.out.println(result.get(true));
        System.out.println(result.get(false));
    }
}