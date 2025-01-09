package sus.amogus.practice_3;

public class Employer {
    private String name;
    private int salary;
    private PositionType position;
    private Division division;

    public Employer(String name, int salary, PositionType position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Division getDivision() {
        return division;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}
