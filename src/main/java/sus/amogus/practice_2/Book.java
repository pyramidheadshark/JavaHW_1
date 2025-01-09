package sus.amogus.practice_2;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    @Override
    public String toString() {
        return "Книга{" +
                "название='" + title + '\'' +
                ", автор='" + author + '\'' +
                '}';
    }
}
