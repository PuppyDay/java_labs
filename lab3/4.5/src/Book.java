public class Book {
    private final String name;
    private final String author;
    private boolean isFree = true;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String toString() {
        return String.format("Книга %s (автор: %s)", this.name, this.author);
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public boolean getIsFree() {
        return this.isFree;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }
}
