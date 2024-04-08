// В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите стихотворение:");
        String text = sc.nextLine();
        String[] words = text.split(" ");
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            String tempStr = words[i].replaceAll("[.,?!:;]+$", "");
            if (
                    tempStr.substring(0, 1).matches("[аеиоуыэюя]")
                    && (tempStr.substring(tempStr.length() - 1).matches("[аеиоуыэюя]"))
            ) {
                count++;
            }
        }
        System.out.println("Количество слов, начинающихся и заканчивающихся гласной буквой: " + count);
    }
}