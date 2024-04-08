// Найти, каких букв, гласных или согласных, больше в каждом предложении текста.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = sc.nextLine();
        String[] sentences = text.split("[.!?]");

        for (String sentence: sentences) {
            int vowels_count = 0, consonants_count = 0;
            for (Character character: sentence.toCharArray()) {
                if ((character >= 'А' && character <= 'Я') || (character >= 'а' && character <= 'я')) {
                    if (String.valueOf(character).matches("[аеиоуыэюя]")) {
                        vowels_count++;
                    } else {
                        consonants_count++;
                    }
                }
            }

            String result = String.format(
                    "В предожении: %s - %d гласных и %d согласных", sentence, vowels_count, consonants_count
            );
            if (vowels_count > consonants_count) {
                result += " (гласных больше)";
            } else if (consonants_count > vowels_count) {
                result += " (согласных больше)";
            } else {
                result += " (согласных и гласных одинаковое количество)";
            }
            System.out.println(result);
        }
    }
}