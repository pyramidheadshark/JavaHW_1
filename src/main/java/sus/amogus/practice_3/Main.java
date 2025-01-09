package sus.amogus.practice_3;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        // Создание сотрудников
        Employer worker1 = new Employer("Vitaliy Zahl", 50000, PositionType.WORKER);
        Employer manager1 = new Employer("Oleg Gazmanov", 80000, PositionType.MANAGER);
        Employer saler1 = new Employer("Yevgeniy Ponasenkov", 60000, PositionType.SALER);
        Employer head1 = new Employer("Boevoy Vertolet", 100000, PositionType.HEAD);

        // Создание отделов
        Division division1 = new Division("Sales");
        Division division2 = new Division("Development");

        // Добавление сотрудников в отделы
        division1.addEmployer(saler1);
        division1.addEmployer(manager1);
        division2.addEmployer(worker1);
        division2.addEmployer(head1);


        // Назначение руководителя отдела
        division1.setHeadOfDivision(manager1);
        division2.setHeadOfDivision(head1);


        // Вывод информации об отделах
        System.out.println(division1);
        System.out.println(division2);

        // Тестирование CSVService
        CSVService csvService = new CSVServiceImpl();
        csvService.exportData(List.of(division1, division2), "src/main/resources/output.csv");
        csvService.importData("src/main/resources/output.csv");
    }
}