// Умножить два многочлена заданной степени, если коэффициенты многочленов хранятся в различных списках.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> polynomial1 = new ArrayList<>(Arrays.asList(0, 1, 2));
        List<Integer> polynomial2 = new ArrayList<>(Arrays.asList(1, 3));

        System.out.println("Имеются многочлены:");
        System.out.println(polynomialToString(polynomial1));
        System.out.println(polynomialToString(polynomial2));
        
        List<Integer> result1 = mul(polynomial1, polynomial2);
        List<Integer> result2 = mul(polynomial2, polynomial1);

        System.out.println("Результат polynomial1 * polynomial2:");
        System.out.println(polynomialToString(result1));
        System.out.println("Результат polynomial2 * polynomial1:");
        System.out.println(polynomialToString(result2));
    }

    public static List<Integer> mul(List<Integer> polynomial1, List<Integer> polynomial2) {
        int size = Math.max(polynomial1.size(), polynomial2.size());
        int min_size = Math.min(polynomial1.size(), polynomial2.size());

        List<Integer> result = new ArrayList<>(Collections.nCopies((2 * size - 1), 0));


        if (min_size != size) {
            if (polynomial1.size() == min_size) {
                polynomial1.addAll(Collections.nCopies((size - min_size), 0));
            } else {
                polynomial2.addAll(Collections.nCopies((size - min_size), 0));
            }

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                result.set(i + j, result.get(i + j) + polynomial1.get(i) * polynomial2.get(j));
            }
        }
        return result;
    }

    public static String polynomialToString(List<Integer> polynomial1) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < polynomial1.size(); i++){
            if (polynomial1.get(i) != 0) {
                if (!result.toString().isEmpty()) {
                    result.append(" + ");
                }
                if (i > 0) {
                    result.append(String.format("%dx^%d", polynomial1.get(i), i));
                } else {
                    result.append(String.format("%d", polynomial1.get(i)));
                }
            }
        }
        return result.toString();
    }
}