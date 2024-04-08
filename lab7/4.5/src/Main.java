// Заменить все одинаковые рядом стоящие символы в тексте одним символом.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = sc.nextLine();

        char tempChar = 0;
        char[] textChar = text.toCharArray();
        int regulation = 0;

        for (int i = 0; i < textChar.length; i++) {
            if (tempChar == textChar[i]) {
                text = text.substring(0, i - regulation) + text.substring(i - regulation + 1);
                regulation++;
            } else {
                tempChar = textChar[i];
            }
        }
        System.out.println(text);
    }
}