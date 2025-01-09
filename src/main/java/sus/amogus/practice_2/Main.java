package sus.amogus.practice_2;

public class Main {
    public static void main(String[] args) {
        ShoeBox shoeBox = new ShoeBox();
        Shoe shoe = new Shoe("Nike Air Max", "42");
        shoeBox.put(shoe);
        Shoe openedShoe = shoeBox.open();
        System.out.println("Содержимое коробки: " + openedShoe);
        shoeBox.removeFromBox();

        BookBox bookBox = new BookBox();
        Book book = new Book("1984", "George Orwell");
        bookBox.put(book);
        Book openedBook = bookBox.open();
        System.out.println("Содержимое коробки: " + openedBook);
        bookBox.removeFromBox();

        BeerBox beerBox = new BeerBox();
        Beer beer = new Beer("Heineken", "0.5L");
        beerBox.put(beer);
        Beer openedBeer = beerBox.open();
        System.out.println("Содержимое коробки: " + openedBeer);
        beerBox.removeFromBox();
    }
}
