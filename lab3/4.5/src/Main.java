// Построить модель программной системы.
// Система Библиотека. Читатель оформляет Заказ на Книгу.
// Система осуществляет поиск в Каталоге.
// Библиотекарь выдает Читателю Книгу на абонемент или в читальный зал.
// При невозвращении Книги Читателем он может быть занесен Администратором в «черный список».

public class Main {
    public static void main(String[] args) {
        Library library = new Library(
                "Ромашка",
                "ул. 3 гражданская, д.13",
                new Librarian[]{
                        new Librarian("Иванов", "Иван", "Иванович", false),
                        new Librarian("Петров", "Петр", "Петрович", false),
                },
                new Librarian("Зайцева", "Татьяна", "Ивановна", true),
                7,
                12
        );
        library.setCatalog(new Book[]{
                new Book("Руслан и Людмила", "Пушкин"),
                new Book("Война и мир", "Толстой"),
                new Book("Преступление и наказание", "Достоевский"),
                new Book("Мастер и Маргарита", "Булгаков"),
                new Book("Собачье сердце", "Булгаков"),
        });
        System.out.printf("Информация о библиотеке:\n" + library);

        Reader reader1 = new Reader(1, "Гендина", "Нина", "Борисовна");
        Reader reader2 = new Reader(2, "Баканов", "Роман", "Викторович");
        Reader reader3 = new Reader(3, "Шишкин", "Сегей", "Андреевич");

        // Читатели присоединяются к библиотеке
        library.addReaderToLibrary(reader1);
        library.addReaderToLibrary(reader2);
        library.addReaderToLibrary(reader3);

        System.out.println("\n\nВсе читатели библиотеки:\n" + library.getReaders());

        // Оформление заказов на книги
        System.out.println(library.orderBook(reader1, "Руслан и Людмила", BookIssueType.SUBSCRIPTION));
        System.out.println(library.orderBook(reader2, "Война и мир", BookIssueType.READING_ROOM));
        System.out.println(library.orderBook(reader3, "Руслан и Людмила", BookIssueType.READING_ROOM));
        System.out.println(library.orderBook(reader3, "Собачье сердце", BookIssueType.SUBSCRIPTION));
        System.out.println();

        // Проверка просроченного владения книгой и занесение в черный список
        System.out.println("Пользователи, просрочившие сдачу книги: " + library.checkReaders());

        // Возврат книги
        System.out.println();
        System.out.println(library.returnBook(reader1, "Руслан и Людмила"));
        System.out.println(library.returnBook(reader1, "Война и мир"));
        System.out.println(library.returnBook(reader2, "Война и мир"));
        System.out.println(library.returnBook(reader3, "Руслан и Людмила"));
        System.out.println(library.returnBook(reader3, "Собачье сердце"));
    }
}
