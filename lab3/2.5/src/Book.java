import java.util.Arrays;
import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String[] authors;
    private String publishingHouse;
    private int yearOfPublishing;
    private int numberOfPages;
    private float price;
    private String binding;

    public Book() {}

    public Book(int id, String name, String[] authors, String publishingHouse, int yearOfPublishing, int numberOfPages, float price, String binding) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.binding = binding;
    }

    public String toString() {
        return String.format(
                "Book(%d) %s.\tAuthors: %s.\tPublished: %s (%d).\tPrice: %f.\t%d pages.\tBinding: %s.\n",
                this.id, this.name, Arrays.toString(this.authors), this.publishingHouse, this.yearOfPublishing,
                this.price, this.numberOfPages, this.binding
        );
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getAuthors() {
        return this.authors;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getPublishingHouse() {
        return this.publishingHouse;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public int getYearOfPublishing() {
        return this.yearOfPublishing;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getBinding() {
        return this.binding;
    }

    public boolean belongsToAuthor(String author) {
        for(String el: this.authors) {
            if (Objects.equals(el, author)) {
                return true;
            }
        }

        return false;
    }
}

