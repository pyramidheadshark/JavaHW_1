package sus.amogus.practice_3;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public interface CSVService {
    List<Division> importData(String filePath) throws IOException, CsvException;
    void exportData(List<Division> divisions, String filePath) throws IOException, CsvException;
}