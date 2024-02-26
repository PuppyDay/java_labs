// Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше (больше)
// средней, а также длину.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите длину массива");

        int arr_size = 0;
        if (sc.hasNextInt()) {
            arr_size = sc.nextInt();
        }

        sc.nextLine();

        String[] arr = new String[arr_size];
        int sum_length = 0;

        System.out.println("Введите элементы массива");

        for (int i = 0; i < arr_size; i++) {
            String str = sc.nextLine();
            sum_length += str.length();
            arr[i] = str;
        }

        float avg_length = (float) sum_length / arr_size;

        System.out.println("Строки, длина которых меньше средней " + avg_length + ":");

        for (int i = 0; i < arr_size; i++) {
            if (arr[i].length() < avg_length) {
                System.out.println("(" + arr[i].length() + ") " + arr[i]);
            }
        }

        sc.close();
    }
}