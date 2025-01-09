package sus.amogus.practice_2;

public class BookBox implements Box<Book> {
    private Book book;
    @Override
    public Book open() {
        System.out.println("Открыта книжная коробка");
        return book;
    }
    @Override
    public void put(Book item) {
        this.book = item;
        System.out.println("Помещена книга в коробку: " + item);
    }
    @Override
    public Book removeFromBox() {
        Book removedBook = this.book;
        this.book = null;
        System.out.println("Из книжной коробки забрали: " + removedBook);
        return removedBook;
    }
}
