// Ввести n слов с консоли. Найти слово, в котором число различных символов минимально.
// Если таких слов несколько, найти первое из них.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество слов");

        int count = 0;
        if (sc.hasNextInt()) {
            count = sc.nextInt();
        }

        sc.nextLine();

        String min_word = null;
        int min_count = -1;

        System.out.println("Введите слова:");

        for (int i = 0; i < count; i++) {
            String word = sc.next();
            if (min_count < 0 || word.chars().distinct().count() < min_count) {
                min_count = (int) word.chars().distinct().count();
                min_word = word;
            }
        }

        System.out.println("Слово, в котором число различных символов минимально: " + min_word);

        sc.close();
    }
}