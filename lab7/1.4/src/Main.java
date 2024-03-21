// В тексте слова заданной длины заменить указанной подстрокой,
// длина которой может не совпадать с длиной слова.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = sc.nextLine();

        System.out.println("Введите длину слова:");
        int wordLength = sc.nextInt();

        sc.nextLine();
        System.out.println("Введите подстроку-заменитель:");
        String replacementStr = sc.nextLine();

        String[] arr = text.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String tempStr = arr[i].replaceAll("[.,?!:;]+$", "");

            if (tempStr.length() == wordLength) {
                arr[i] = arr[i].replaceAll(tempStr, replacementStr);
            }
        }

        System.out.println("После замены:");
        System.out.println(String.join(" ", arr));
    }
}