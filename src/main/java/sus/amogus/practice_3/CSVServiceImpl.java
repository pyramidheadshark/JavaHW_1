package sus.amogus.practice_3;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVServiceImpl implements CSVService {
    @Override
    public List<Division> importData(String filePath) throws IOException, CsvException {
        System.out.println("Импорт данных из файла: " + filePath);
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (String[] record : records) {
                if (record.length != 4) {
                    System.err.println("Неверный формат записи в строке: " + Arrays.toString(record));
                    continue;
                }
                String divisionName = record[0];
                String employerName = record[1];
                int salary = Integer.parseInt(record[2]);
                PositionType position = PositionType.valueOf(record[3]);

                Division division = new Division(divisionName);
                Employer employer = new Employer(employerName, salary, position);
                division.addEmployer(employer);
                System.out.println("Импортирован сотрудник " + employer + " в отдел " + divisionName);
            }
        }
        return null;
    }

    @Override
    public void exportData(List<Division> divisions, String filePath) throws IOException, CsvException {
        System.out.println("Экспорт данных в файл: " + filePath);
        try(CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            List<String[]> records = new ArrayList<>();
            for (Division division : divisions){
                for(Employer employer : division.getEmployerList()){
                    records.add(new String[]{division.getName(), employer.getName(),
                            String.valueOf(employer.getSalary()), String.valueOf(employer.getPosition())});
                }
                if(division.getHeadOfDivision() != null){
                    records.add(new String[] {division.getName(), division.getHeadOfDivision().getName(),
                            String.valueOf(division.getHeadOfDivision().getSalary()), String.valueOf(division.getHeadOfDivision().getPosition())});
                }
            }
            writer.writeAll(records);
        }
    }
}