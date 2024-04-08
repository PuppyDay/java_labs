// Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в объекте HashMap.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> polynomial1 = createPolynomial(
                new ArrayList<Integer>(Arrays.asList(1, 2, 5, 10, 0, 0, 15))
        );
        HashMap<Integer, Integer> polynomial2 = createPolynomial(
                new ArrayList<Integer>(Arrays.asList(0, 0, 23, 3, 4, 0))
        );

        System.out.println("Исходные многочлены:");
        System.out.println(polynomialToString(polynomial1));
        System.out.println(polynomialToString(polynomial2));

        HashMap<Integer, Integer> result1 = sum(polynomial1, polynomial2);
        HashMap<Integer, Integer> result2 = sum(polynomial2, polynomial1);

        System.out.println("Результат polynomial1 + polynomial2:");
        System.out.println(polynomialToString(result1));
        System.out.println("Результат polynomial2 + polynomial1:");
        System.out.println(polynomialToString(result2));
    }

    public static HashMap<Integer, Integer> createPolynomial(List<Integer> coefficients) {
        HashMap<Integer, Integer> result = new HashMap<>();
        int degree = 0;

        for(int coefficient: coefficients) {
            result.put(degree, coefficient);
            degree++;
        }

        return result;
    }

    public static HashMap<Integer, Integer> sum(HashMap<Integer, Integer> polynomial1, HashMap<Integer, Integer> polynomial2) {
        int size = Math.max(polynomial1.size(), polynomial2.size());
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int coefficient = 0;

            if (polynomial1.containsKey(i)) {
                coefficient += polynomial1.get(i);
            }

            if (polynomial2.containsKey(i)) {
                coefficient += polynomial2.get(i);
            }

            result.put(i, coefficient);
        }

        return result;
    }

    public static String polynomialToString(HashMap<Integer, Integer> polynomial) {
        StringBuilder result = new StringBuilder();

        for(int key : polynomial.keySet()) {
            if (polynomial.get(key) != 0) {
                if (!Objects.equals(String.valueOf(result), "")) {
                    result.append(" + ");
                }

                if (key == 0) {
                    result.append(String.format("%d", polynomial.get(key)));
                } else {
                    result.append(String.format("%d*x^%d", polynomial.get(key), key));
                }
            }

        }

        return String.valueOf(result);
    }
}