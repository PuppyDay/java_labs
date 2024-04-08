// Выполнить задания из варианта 2 лабораторной работы 3,
// реализуя собственные обработчики исключений и исключения ввода/вывода.

// Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы
// setТип(), getТип(), toString(). Определить дополнительно методы в классе, создающем массив объектов.
// Задать критерий выбора данных и вывести эти данные на консоль.
// Book: id, Название, Автор(ы), Издательство, Год издания, Количество страниц, Цена, Переплет.
// Создать массив объектов.
// Вывести: a) список книг заданного автора;
// b) список книг, выпущенных заданным издательством;
// c) список книг, выпущенных после заданного года.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Укажите количество книг:");

        int count = 0;

        try {
            count = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести число");
            return;
        }

        Book[] books = new Book[count];
        for (int i = 0; i < count; i++) {
            try {
                System.out.println("Введите данные для книги " + (i + 1) + ": ");

                System.out.print("Укажите название: ");
                String name = sc.nextLine();

                System.out.print("Укажите авторов: ");
                String[] authors = sc.nextLine().split(" ");

                System.out.print("Укажите издательство: ");
                String publishingHouse = sc.nextLine();

                System.out.print("Укажите год издания: ");
                int year = 0;
                try {
                    year = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Год должен быть указан числом");
                }

                System.out.print("Укажите количество страниц: ");
                int numberOfPages = 0;
                try {
                    numberOfPages = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Количество страниц должно быть указано числом");
                }

                System.out.print("Укажите цену: ");
                float price = 0;
                try {
                    price = sc.nextFloat();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Цена должна быть числом с плавающей точкой");
                }

                System.out.print("Укажите переплет: ");
                String binding = sc.nextLine();

                books[i] = new Book(i + 1, name, authors, publishingHouse, year, numberOfPages, price, binding);
            } catch (InputMismatchException e) {
                System.out.println("Данные для " + (i + 1) + " книги введены неверно: " + e);
                return;
            }
        }

        Collection collection = new Collection(books);

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
        try {
            System.out.println(collection.getBooksPublishedAfterGivenYear(year));
        } catch (BookException e) {
            System.out.println("Произошла ошибка: " + e);
        }
    }
}

