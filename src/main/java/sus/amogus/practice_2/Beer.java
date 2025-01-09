package sus.amogus.practice_2;

public class Beer {
    private String brand;
    private String volume;

    public Beer(String brand, String volume) {
        this.brand = brand;
        this.volume = volume;
    }
    @Override
    public String toString() {
        return "Пиво{" +
                "бренд='" + brand + '\'' +
                ", объем='" + volume + '\'' +
                '}';
    }
}
