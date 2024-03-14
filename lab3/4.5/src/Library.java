import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Library {
    private final String name;
    private final String address;
    private final Librarian[] librarians;
    private final Librarian administrator;
    private final int permissibleNumberOfDaysForStoringBook;
    private final int permissibleNumberOfHoursOfUsingBook;
    private HashMap<String, Book> catalog;
    private HashMap<Integer, Reader> readers;

    public Library(String name, String address, Librarian[] librarians, Librarian administrator, int permissibleNumberOfDaysForStoringBook, int permissibleNumberOfHoursOfUsingBook) {
        this.name = name;
        this.address = address;
        this.librarians = librarians;
        this.administrator = administrator;
        this.permissibleNumberOfDaysForStoringBook = permissibleNumberOfDaysForStoringBook;
        this.permissibleNumberOfHoursOfUsingBook = permissibleNumberOfHoursOfUsingBook;
        this.readers = new HashMap<>();
    }

    public String toString() {
        return String.format("""
                        Библиотека %s по адресу: %s. Администратор: %s.
                        Допустимое количество дней аренды книги: %d.
                        Допустимое количество часов пользования книгой в библиотеке: %d.""",
                this.name, this.address, this.administrator,
                this.permissibleNumberOfDaysForStoringBook, this.permissibleNumberOfHoursOfUsingBook
        );
    }

    public void setCatalog(Book[] books) {
        this.catalog = new HashMap<>();
        for (Book book: books) {
            this.catalog.put(book.getName(), book);
        }
    }

    public String getReaders() {
        StringBuilder result = new StringBuilder();

        for (Reader reader: this.readers.values()) {
            result.append(reader).append("\n");
        }

        return String.valueOf(result);
    }

    public String orderBook(Reader reader, String bookName, BookIssueType bookIssueType) {
        if (!this.readers.containsKey(reader.getId())) {
            return String.format("Читатель %s не принадлежит библиотеке", reader);
        }

        if (reader.getIsBanned()) {
            return String.format("Читатель %s забанен", reader);
        }

        if (!this.catalog.containsKey(bookName)) {
            return String.format("Книги %s нет в библиотеке", bookName);
        }

        if (!this.catalog.get(bookName).getIsFree()) {
            return String.format("Книга %s в данный момент занята", bookName);
        }

        int randomLibrarian = new Random().nextInt(this.librarians.length);
        this.librarians[randomLibrarian].makeOrder(reader, this.catalog.get(bookName), bookIssueType);
        return String.format("Книга %s выдана: %s", bookName, reader);
    }

    public String returnBook(Reader reader, String bookName) {
        if (!this.readers.containsKey(reader.getId())) {
            return String.format("Читатель %s не принадлежит библиотеке", reader);
        }

        if (!this.catalog.containsKey(bookName)) {
            return String.format("Книги %s нет в библиотеке", bookName);
        }

        if (!reader.haveBook(this.catalog.get(bookName))) {
            return String.format("Книги %s нет у %s", bookName, reader);
        }

        int randomLibrarian = new Random().nextInt(this.librarians.length);
        this.librarians[randomLibrarian].returnBook(reader, this.catalog.get(bookName));

        if (!reader.booksWithExpiredTimeExists(permissibleNumberOfDaysForStoringBook, permissibleNumberOfHoursOfUsingBook)) {
            reader.setIsBanned(false);
            return String.format("Книга %s возвращена, %s нет в черном списке", bookName, reader);
        }

        return String.format("Книга %s возвращена от %s", bookName, reader);
    }

    public void addReaderToLibrary(Reader reader) {
        this.readers.put(reader.getId(), reader);
    }

    public List<Reader> checkReaders() {
        List<Reader> bannedReaders = new ArrayList<>();

        for (Reader reader: this.readers.values()) {
            if (reader.booksWithExpiredTimeExists(permissibleNumberOfDaysForStoringBook, permissibleNumberOfHoursOfUsingBook)) {
                reader.setIsBanned(true);
                bannedReaders.add(reader);
            }
        }
        return bannedReaders;
    }
}

