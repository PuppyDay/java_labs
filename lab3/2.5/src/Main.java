// Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
// setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль.
// Book: id, Название, Автор(ы), Издательство, Год издания, Количество страниц, Цена, Переплет.
// Создать массив объектов.
// Вывести: a) список книг заданного автора;
// b) список книг, выпущенных заданным издательством;
// c) список книг, выпущенных после заданного года.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Collection collection = new Collection(new Book[]{
                new Book(1, "Приключения зайки", new String[]{"Иванов", "Петров"}, "Омега",
                        2000, 100, 102f, "Кожанный"),
                new Book(2, "Приключения мишки", new String[]{"Иванов"}, "Омега",
                        2001, 110, 106f, "Кожанный"),
                new Book(3, "Приключения ежика", new String[]{"Петров"}, "Альфа",
                        2001, 120, 107f, "Кожанный"),
                new Book(4, "Приключения крокодила", new String[]{"Иванов", "Петров", "Сидоров", "Борисов"},
                        "Альфа", 2002, 130, 108f, "Кожанный"),
                new Book(5, "Приключения лисенка", new String[]{"Иванов", "Петров"}, "Омега",
                        2003, 140, 109f, "Кожанный"),
        });

        System.out.println("Укажите автора:");
        String author = sc.next();
        System.out.println("Список книг автора " + author + ":");
        System.out.println(collection.getBooksByAuthor(author));

        System.out.println("Укажите издательство:");
        String publishingHouse = sc.next();
        System.out.println("Список книг, выпущенных " + publishingHouse + ":");
        System.out.println(collection.getBooksPublishedByGivenPublisher(publishingHouse));

        System.out.println("Укажите год:");
        int year = sc.nextInt();
        System.out.println("Список книг, выпущенных после " + year + " года:");
        System.out.println(collection.getBooksPublishedAfterGivenYear(year));
    }
}

