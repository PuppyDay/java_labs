// Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше (больше)
// средней, а также длину.

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество строк");

        int count = 0;
        if (sc.hasNextInt()) {
            count = sc.nextInt();
        }

        sc.nextLine();

        String[] arr = new String[count];
        int sum_length = 0;

        System.out.println("Введите строки");

        for (int i = 0; i < count; i++) {
            String str = sc.nextLine();
            sum_length += str.length();
            arr[i] = str;
        }

        float avg_length = (float) sum_length / count;

        System.out.println("Строки, длина которых меньше средней " + avg_length + ":");

        for (int i = 0; i < count; i++) {
            if (arr[i].length() < avg_length) {
                System.out.println("(" + arr[i].length() + ") " + arr[i]);
            }
        }

        System.out.println("Гендина Нина Борисовна");
        System.out.println("Задание получено 09.02.2024 14:30");
        Date date = new Date();
        System.out.println("Дата и время сдачи " + date.toString());

        sc.close();
    }
}