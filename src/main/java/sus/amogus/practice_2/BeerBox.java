package sus.amogus.practice_2;

public class BeerBox implements Box<Beer> {
    private Beer beer;
    @Override
    public Beer open() {
        System.out.println("Открыта пивная коробка");
        return beer;
    }
    @Override
    public void put(Beer item) {
        this.beer = item;
        System.out.println("Помещено пиво в коробку: " + item);
    }
    @Override
    public Beer removeFromBox() {
        Beer removedBeer = this.beer;
        this.beer = null;
        System.out.println("Из пивной коробки забрали: " + removedBeer);
        return removedBeer;
    }
}