public class Reader {
    public void makeOrder(Library library, String bookName) {
        if (!library.bookExistsInLibrary(bookName)) {
            System.out.println("Данной книги сейчас нет в библиотеке.");
        }
    }
}
