// Выполнить задания из варианта 2 лабораторной работы 3,
// реализуя собственные обработчики исключений и исключения ввода/вывода.

// Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
// setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль.
// Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки. Создать массив объектов.
// Вывести: a) список абитуриентов, имеющих неудовлетворительные оценки;
// b) список абитуриентов, средний балл у которых выше заданного;
// c) выбрать заданное число n абитуриентов, имеющих самый высокий средний балл
// (вывести также полный список абитуриентов, имеющих полупроходной балл).

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Укажите количество студентов:");

        int count = 0;

        try {
            count = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число");
            return;
        }

        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            try {
                System.out.println("Введите данные для студента " + (i + 1) + ": ");

                System.out.print("Укажите ФИО: ");
                String[] fio = sc.nextLine().split(" ");
                if (fio.length != 3) {
                    throw new InputMismatchException("ФИО должно состоять из 3 слов");
                }

                System.out.print("Укажите адрес: ");
                String address = sc.nextLine();

                System.out.print("Укажите телефон: ");
                String phone = sc.nextLine();
                if (!phone.matches("\\d+")) {
                    throw new InputMismatchException("Телефон должен состоять только из цифр");
                }

                System.out.print("Укажите оценки: ");
                String[] marks = sc.nextLine().split(" ");
                int[] marksArray = new int[marks.length];
                try {
                    marksArray = Arrays.stream(marks).mapToInt(Integer::parseInt).toArray();
                } catch (NumberFormatException e) {
                    throw new InputMismatchException("Оценки должны быть целыми числами");
                }

                students[i] = new Student(i + 1, fio[0], fio[1], fio[2], address, phone, marksArray);
            } catch (InputMismatchException e) {
                System.out.println("Данные для " + (i + 1) + " студента введены неверно: " + e);
                return;
            }
        }

        Collection collection = new Collection(students);

        System.out.println("Список абитуриентов, имеющих неудовлетворительные оценки:");
        System.out.println(collection.getStudentsWithBadMarks());

        System.out.println("Укажите средний балл:");
        int averageMark = sc.nextInt();
        System.out.println("Список абитуриентов, средний балл у которых выше " + averageMark + ":");

        try {
            System.out.println(collection.getStudentsWithAverageMarkAboveGiven(averageMark));
        } catch (StudentException e) {
            System.out.println("Произошла ошибка: " + e);
        }

        System.out.println("Укажите количество абитуриентов:");
        int n = sc.nextInt();
        System.out.println(n + " абитуриентов, имеющих самый высокий средний балл:");

        try {
            System.out.println(collection.getStudentsWithMaxAverageMark(n));
        } catch (StudentException e) {
            System.out.println("Произошла ошибка: " + e);
        }

        System.out.println("Абитуриентов, имеющие полупроходной балл:");

        try {
            System.out.println(collection.getStudentsWithSemiPassingMark(n));
        } catch (StudentException e) {
            System.out.println("Произошла ошибка: " + e);
        }
    }
}