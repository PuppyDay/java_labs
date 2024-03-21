// В тексте после k-го символа вставить заданную подстроку.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = sc.nextLine();

        System.out.println("Введите номер символа:");
        int k = sc.nextInt();

        sc.nextLine();
        System.out.println("Введите подстроку:");
        String str = sc.nextLine();

        System.out.println("Результат:");
        System.out.println(new StringBuffer(text).insert(k, str));
    }
}