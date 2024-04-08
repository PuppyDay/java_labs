import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Collection {
    private final Book[] books;

    public Collection(Book[] books) {
        this.books = books;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Book book: this.books) {
            result.append(book);
        }

        return String.valueOf(result);
    }

    public Collection getBooksByAuthor(String author) {
        Stream<Book> result =  Arrays.stream(this.books).filter((b) -> b.belongsToAuthor(author));
        return new Collection(result.toArray(Book[]::new));
    }

    public Collection getBooksPublishedByGivenPublisher(String publishingHouse) {
        Stream<Book> result = Arrays.stream(this.books).filter((b) -> Objects.equals(b.getPublishingHouse(), publishingHouse));
        return new Collection(result.toArray(Book[]::new));
    }

    public Collection getBooksPublishedAfterGivenYear(int year) throws BookException {
        if (year < 1700) {
            throw new BookException("Год должен быть больше 1700");
        }
        Stream<Book> result = Arrays.stream(this.books).filter((b) -> b.getYearOfPublishing() > year);
        return new Collection(result.toArray(Book[]::new));
    }
}
