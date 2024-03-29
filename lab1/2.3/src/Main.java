// Числа, которые делятся на 3 или на 9.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите длину массива");

        int arr_size = 0;
        if (sc.hasNextInt()) {
            arr_size = sc.nextInt();
        }

        int[] arr = new int[arr_size];

        System.out.println("Введите элементы массива");

        for (int i = 0; i < arr_size; i++) {
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }

        System.out.println("Числа, делящиеся на 3 или 9:");

        for (int i = 0; i < arr_size; i++) {
            if ((arr[i] % 3 == 0) || (arr[i] % 9 == 0)) {
                System.out.print(arr[i] + " ");
            }
        }

        sc.close();
    }
}