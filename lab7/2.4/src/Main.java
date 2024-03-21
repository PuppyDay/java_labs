// Найти, каких букв, гласных или согласных, больше в каждом предложении текста.

import java.text.BreakIterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = sc.nextLine();

        BreakIterator iterator = BreakIterator.getWordInstance();
        iterator.setText(text);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            System.out.println(start);
            System.out.println(end);
            System.out.println(text.substring(start, end));
        }
    }
}