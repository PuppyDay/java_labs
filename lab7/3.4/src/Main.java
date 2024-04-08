// Во всех вопросительных предложениях текста найти и напечатать без повторений
// слова заданной длины.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите длину слов:");
        int len = sc.nextInt();
        sc.nextLine();

        System.out.println("Введите текст:");
        String text = sc.nextLine();
        Pattern pattern = Pattern.compile("([^.!?]+[.!?])");
        Matcher matcher = pattern.matcher(text);

        Set<String> existing_words = new HashSet<>();

        System.out.println("Получившиеся слова:");

        while (matcher.find()) {
            String part = text.substring(matcher.start(), matcher.end());
            if (part.endsWith("?")) {
                for (String word: part.split(" ")) {
                    String tempStr = word.replaceAll("[.,?!:;]+$", "");
                    if ((tempStr.length() == len) && !(existing_words.contains(tempStr))){
                        System.out.println(tempStr);
                        existing_words.add(tempStr);
                    }
                }
            }
        }
    }
}