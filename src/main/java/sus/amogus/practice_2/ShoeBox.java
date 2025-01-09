package sus.amogus.practice_2;

public class ShoeBox implements Box<Shoe> {
    private Shoe shoe;
    @Override
    public Shoe open() {
        System.out.println("Открыта обувная коробка");
        return shoe;
    }
    @Override
    public void put(Shoe item) {
        this.shoe = item;
        System.out.println("Помещена обувь в коробку: " + item);
    }
    @Override
    public Shoe removeFromBox() {
        Shoe removedShoe = this.shoe;
        this.shoe = null;
        System.out.println("Из обувной коробки забрали: " + removedShoe);
        return removedShoe;
    }
}