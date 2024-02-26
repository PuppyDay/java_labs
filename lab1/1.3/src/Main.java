// 3. Создать приложение, выводящее n строк с переходом и без перехода на новую строку.

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

        System.out.println("Введите строку");
        String str = sc.nextLine();

        System.out.println(count + " строк с переходом на новую строку:");

        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }

        System.out.println(count + " строк без перехода на новую строку:");

        for (int i = 0; i < count; i++) {
            System.out.print(str);
        }

        sc.close();
    }
}
