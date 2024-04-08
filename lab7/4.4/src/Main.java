// В тексте исключить подстроку максимальной длины,
// начинающуюся и заканчивающуюся заданными символами.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = sc.nextLine();

        System.out.println("Введите начальный символ:");
        String start_char = sc.nextLine();

        System.out.println("Введите конечных:");
        String end_char = sc.nextLine();

        Pattern pattern = Pattern.compile(String.format("(%s[^%s%s]+%s)", start_char, start_char, end_char, end_char));
        Matcher matcher = pattern.matcher(text);
        int max_len = 0;
        String substr = "";
        while (matcher.find()) {
            String part = text.substring(matcher.start(), matcher.end()).trim();
            if (part.length() > max_len) {
                max_len = part.length();
                substr = part;
            }
        }
        System.out.println(text.replaceAll(substr, ""));
    }
}