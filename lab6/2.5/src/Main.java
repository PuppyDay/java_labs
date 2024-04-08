// Во входном файле расположены два набора положительных чисел;
// между наборами стоит отрицательное число. Построить два списка C1 и С2,
// элементы которых содержат соответственно числа 1-го и 2-го набора таким образом,
// чтобы внутри одного списка числа были упорядочены по возрастанию.
// Затем объединить списки C1 и С2 в один упорядоченный список, изменяя только значения
// полей ссылочного типа.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> c1 = new LinkedList<>();
        List<Integer> c2 = new LinkedList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input_file.txt"));
            String[] numbers = reader.readLine().split(" ");
            boolean key = true;

            for (String number: numbers) {
                int el = Integer.parseInt(number);

                if (el < 0){
                    key = false;
                    continue;
                }

                if (key) {
                    c1.add(el);
                } else {
                    c2.add(el);
                }
            }
            Collections.sort(c1);
            Collections.sort(c2);

            System.out.println("Исходный список 1:");
            System.out.println(c1);
            System.out.println("Исходный список 2:");
            System.out.println(c2);

            c1.addAll(c2);
            Collections.sort(c1);
            System.out.println("Итоговый соединенный список:");
            System.out.println(c1);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}