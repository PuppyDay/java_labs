public class Librarian {
    private final String lastName;
    private final String name;
    private final String patronymic;
    private final boolean isAdministrator;

    public Librarian(String lastName, String name, String patronymic, boolean isAdministrator) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.isAdministrator = isAdministrator;
    }

    public String toString() {
        String result = String.format("Библиотекарь %s %s %s", this.lastName, this.name, this.patronymic);
        if (this.isAdministrator) {
            result += " (администратор)";
        }

        return result;
    }

    public void makeOrder(Reader reader, Book book, BookIssueType bookIssueType) {
        reader.makeOrder(book, bookIssueType);
        book.setFree(false);
    }

    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
        book.setFree(true);
    }
}

