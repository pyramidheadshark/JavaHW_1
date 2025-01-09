package sus.amogus.practice_2;

public class Shoe {
    private String model;
    private String size;

    public Shoe(String model, String size) {
        this.model = model;
        this.size = size;
    }
    @Override
    public String toString() {
        return "Обувь{" +
                "модель='" + model + '\'' +
                ", размер='" + size + '\'' +
                '}';
    }
}
