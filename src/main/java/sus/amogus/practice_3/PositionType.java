package sus.amogus.practice_3;

public enum PositionType {
    WORKER(1.0),
    MANAGER(1.5),
    SALER(1.2),
    HEAD(2.0);

    private double multiplier;
    PositionType(double multiplier){
        this.multiplier = multiplier;
    }

    public double getMultiplier(){
        return multiplier;
    }
}
