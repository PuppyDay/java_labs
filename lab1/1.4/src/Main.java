// 4. Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом.

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String correct_password = "1234567890";

        if (args.length == 0) {
            System.out.print("Укажите пароль.");
            return;
        }

        if (Objects.equals(args[0], correct_password))  {
            System.out.print("Введен верный пароль.");
            return;
        }

        System.out.print("Введенный пароль некорректен.");
    }
}