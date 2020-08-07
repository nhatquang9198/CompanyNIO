package dao;

import model.Company;
import utils.CSVReader;
import utils.FileReader;
import utils.ModelFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompanyDao {

    private FileReader fileReader;

    public CompanyDao() {
        this.fileReader = new CSVReader();
    }

    private Company convertStringToCompany(String[] s) {
        int id;
        String name;
        LocalDate foundationDate;
        long capital;
        String country;
        int headquarterId;

//        String[] column = s.split(",", -1);
//
//        id = Integer.parseInt(column[0]);
//        name = column[1];
//        foundationDate = LocalDate.now();
//        capital = Long.parseLong(column[3]);
//        country = column[4];

        return null;
    }

    public void readData(String stringPath) {
        try {
            Stream<String> lines = fileReader.getFileStream(stringPath);

//            System.out.println(lines.collect(Collectors.joining("\n")));
            String s = lines.collect(Collectors.joining("\n"));




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BufferedReader getFile(String stringPath) throws IOException {
        Path path = Paths.get(stringPath);
        BufferedReader reader = Files.newBufferedReader(path);
        return reader;
    }

    public List<Company> readFile(String stringPath) {
        List<Company> companies = new ArrayList<>();

        try (BufferedReader reader = getFile(stringPath)) {
            // skip 1st line
            reader.readLine();
            String line = null;

            int id;
            String name;
            LocalDate foundationDate;
            long capital;
            String country;
            int headquarterId;

            while ((line = reader.readLine()) != null) {
                String[] column = line.split(",");

                id = Integer.parseInt(column[0]);
                name = column[1];
                foundationDate = LocalDate.now();
                capital = Long.parseLong(column[3]);
                country = column[4];

                // Nested try-catch to check if the last field in CSV line is Empty
                // Set field value = -1 if it was
                // REASON: Integer can't parse string value of ""
                try {
                    headquarterId = Integer.parseInt(column[5]);
                } catch (IndexOutOfBoundsException e) {
                    headquarterId = -1;
                }

                Company company = ModelFactory.createCompany(id, name, foundationDate, capital, country, headquarterId);
                companies.add(company);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return companies;
    }

}
