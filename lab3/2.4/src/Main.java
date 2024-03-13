// Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
// setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль.
// Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки. Создать массив объектов.
// Вывести: a) список абитуриентов, имеющих неудовлетворительные оценки;
// b) список абитуриентов, средний балл у которых выше заданного;
// c) выбрать заданное число n абитуриентов, имеющих самый высокий средний балл
// (вывести также полный список абитуриентов, имеющих полупроходной балл).

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Collection collection = new Collection(new Student[]{
                new Student(1,"Гендина", "Нина", "Борисовна",
                        "ул. 3 Гражданская", "79999999999", new int[]{4, 5, 5, 5, 5}),
                new Student(2,"Баканов", "Роман", "Викторович",
                        "ул. Островского", "78888888888", new int[]{4, 4, 4, 5, 4}),
                new Student(3,"Иванов", "Иван", "Иванович",
                        "ул. Краснобогатырская", "76666666666", new int[]{2, 3, 4, 5, 3}),
                new Student(4,"Петров", "Петр", "Петрович",
                        "ул. Арбат", "73333333333", new int[]{2, 3, 4, 4, 4}),
                new Student(5,"Сергеев", "Сергей", "Сергеевич",
                        "ул. Миллионная", "74444444444", new int[]{2, 3, 2, 2, 3})
        });

        System.out.println("Список абитуриентов, имеющих неудовлетворительные оценки:");
        System.out.println(collection.getStudentsWithBadMarks());

        System.out.println("Укажите средний балл:");
        int averageMark = sc.nextInt();
        System.out.println("Список абитуриентов, средний балл у которых выше " + averageMark + ":");
        System.out.println(collection.getStudentsWithAverageMarkAboveGiven(averageMark));

        System.out.println("Укажите количество абитуриентов:");
        int n = sc.nextInt();
        System.out.println(n + " абитуриентов, имеющих самый высокий средний балл:");
        System.out.println(collection.getStudentsWithMaxAverageMark(n));

        System.out.println("Абитуриентов, имеющие полупроходной балл:");
        System.out.println(collection.getStudentsWithSemiPassingMark(n));
    }
}

