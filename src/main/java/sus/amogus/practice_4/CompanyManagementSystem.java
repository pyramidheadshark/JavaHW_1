package sus.amogus.practice_4;

import com.opencsv.exceptions.CsvException;
import sus.amogus.practice_3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompanyManagementSystem {
    private List<Division> divisions = new ArrayList<>();
    private CSVService csvService = new CSVServiceImpl();

    public static void main(String[] args) throws IOException, CsvException {
        CompanyManagementSystem system = new CompanyManagementSystem();
        system.run();
    }
    public void run() throws IOException, CsvException {
        this.divisions = new ArrayList<>();
        // Создание отделов
        Division division1 = new Division("Sales");
        Division division2 = new Division("Development");
        Division division3 = new Division("Marketing");

        this.divisions.addAll(List.of(division1, division2, division3));

        // Добавление сотрудников с разной зарплатой в зависимости от должности
        addEmployer(division1, "Yevgeniy Ponasenkov", PositionType.SALER);
        addEmployer(division1, "Oleg Gazmanov", PositionType.MANAGER);
        addEmployer(division2, "Vitaliy Zahl", PositionType.WORKER);
        addEmployer(division2, "Boevoy Vertolet", PositionType.HEAD);
        addEmployer(division3, "Sample Worker", PositionType.WORKER);
        addEmployer(division3, "Sample Manager", PositionType.MANAGER);


        // Сохранение списка сотрудников в CSV файл
        csvService.exportData(this.divisions, "src/main/resources/employees.csv");

        // Загрузка структуры компании из CSV
        List<Division> importedDivisions = csvService.importData("src/main/resources/employees.csv");
        if(importedDivisions != null){
            this.divisions = importedDivisions;
        }

        // Вывод информации о каждом отделе
        for (Division division : this.divisions) {
            printDivisionInfo(division);
        }
    }
    private void addEmployer(Division division, String name, PositionType position){
        int salary = (int) (10000 * position.getMultiplier());
        Employer employer = new Employer(name, salary, position);
        division.addEmployer(employer);
    }

    private void printDivisionInfo(Division division) {
        System.out.println("\nОтдел: " + division.getName());

        if (division.getHeadOfDivision() != null) {
            System.out.println("  Глава отдела: " + division.getHeadOfDivision().getName() +
                    ", Зарплата: " + division.getHeadOfDivision().getSalary());
        } else {
            System.out.println("  Глава отдела: Не назначен");
        }

        List<Employer> employees = division.getEmployerList();
        long employeeCount = employees.size();
        System.out.println(" Количество сотрудников: " + employeeCount);

        if(employeeCount > 0){
            double averageSalary = employees.stream()
                    .mapToInt(Employer::getSalary)
                    .average().orElse(0);
            System.out.println(" Средняя зарплата сотрудников: " + averageSalary);
        } else {
            System.out.println(" Средняя зарплата сотрудников: 0");
        }
    }
}