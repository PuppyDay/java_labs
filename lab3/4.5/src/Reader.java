import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Reader {
    private final int id;
    private final String lastName;
    private final String name;
    private final String patronymic;
    private boolean isBanned;
    private HashMap<Book, BookIssueType> booksWithIssueType;
    private HashMap<Book, LocalDateTime> booksWithOrderDates;

    public Reader(int id, String lastName, String name, String patronymic) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.booksWithIssueType = new HashMap<>();
        this.booksWithOrderDates = new HashMap<>();
        this.isBanned = false;
    }

    public String toString() {
        return String.format("Читатель %s %s %s (%d)", this.lastName, this.name, this.patronymic, this.id);
    }

    public void makeOrder(Book book, BookIssueType bookIssueType) {
        this.booksWithIssueType.put(book, bookIssueType);
        this.booksWithOrderDates.put(book, LocalDateTime.now());
    }

    public void returnBook(Book book) {
        this.booksWithIssueType.remove(book);
        this.booksWithOrderDates.remove(book);
    }

    public int getId() {
        return this.id;
    }

    public boolean getIsBanned() {
        return this.isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public boolean booksWithExpiredTimeExists(int permissibleNumberOfDaysForStoringBook, int permissibleNumberOfHoursOfUsingBook) {
        for (Book book: booksWithOrderDates.keySet()) {
            BookIssueType bookIssueType = this.booksWithIssueType.get(book);

            if ((bookIssueType == BookIssueType.SUBSCRIPTION) && (Duration.between(LocalDateTime.now(), this.booksWithOrderDates.get(book)).toDays() > permissibleNumberOfDaysForStoringBook)) {
                return true;
            }

            if ((bookIssueType == BookIssueType.READING_ROOM) && (Duration.between(LocalDateTime.now(), this.booksWithOrderDates.get(book)).toHours() > permissibleNumberOfHoursOfUsingBook)) {
                return true;
            }
        }

        return false;
    }

    public boolean haveBook(Book book) {
        return this.booksWithIssueType.containsKey(book) && this.booksWithOrderDates.containsKey(book);
    }
}

