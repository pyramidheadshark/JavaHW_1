package sus.amogus.practice_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Division {
    private String name;
    private Map<String, Employer> employers = new HashMap<>();
    private Employer headOfDivision;

    public Division(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addEmployer(Employer employer) {
        employers.put(employer.getName(), employer);
        employer.setDivision(this);
        if(employer.getPosition() == PositionType.HEAD) {
            setHeadOfDivision(employer);
        }
    }
    public List<Employer> getEmployerList() {
        return new ArrayList<>(employers.values());
    }

    public void setHeadOfDivision(Employer headOfDivision) {
        this.headOfDivision = headOfDivision;
    }

    public Employer getHeadOfDivision() {
        return headOfDivision;
    }
    @Override
    public String toString() {
        return "Division{" +
                "name='" + name + '\'' +
                ", employers=" + employers.values() +
                ", headOfDivision=" + headOfDivision +
                '}';
    }
}