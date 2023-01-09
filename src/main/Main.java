package main;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.sql.*;

import static org.apache.commons.collections4.CollectionUtils.size;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException, SQLException, ClassNotFoundException {

        List<String[]> list = csvReader("src/resources/Гранты.csv");
        List<Business> businessList = Business.Fielder(list);
        List<Grant> grants = Grant.Fielder(list,businessList);
        SQLiteQuerrer.workersQuery();
        SQLiteQuerrer.grantAmountQuery();
        Visualiser.Visualise(SQLiteQuerrer.yearQuery());
        Visualiser.PieVisualise(SQLiteQuerrer.yearQuery());
        }

    public static  List<String[]> csvReader(String fileName) throws IOException, CsvValidationException {
        FileReader file = new FileReader(fileName);
        CSVReader reader = new CSVReader(file);
        List<String[]> list = new ArrayList<>();

        String[] line;
        while ((line = reader.readNext()) != null) {
            list.add(line);
        }
        return list;
    }

}

