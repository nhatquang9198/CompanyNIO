package dao;

import model.Company;
import io.FileReader;
import util.FileReaderFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompanyDao {

    private FileReader fileReader;

    public CompanyDao() {
        this.fileReader = FileReaderFactory.getInstance().getCSVReader();
    }


    public List<Company> readData(String stringPath) {
        List<Company> companies = new ArrayList<>();

        try (Stream<String> lines = fileReader.getFileStream(stringPath)) {
            String jointRowsData = lines.collect(Collectors.joining("\n"));

            String[] arrayOfString = jointRowsData.split("\n");

            Arrays.asList(arrayOfString).stream()
                    .skip(1)
                    .forEach(c -> {
                        companies.add(convertStringToCompany(c));
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return companies;

    }

    public List<Company> watchForFile(String stringPath) {
        Path path = Paths.get(stringPath);

        while (true) {
            if (Files.exists(path)) {
                return readData(stringPath);
            }
        }
    }

    public void changeFileReaderType(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    private Company convertStringToCompany(String stringCompany) {
        String[] column = stringCompany.split(",");

        int id = Integer.parseInt(column[0]);
        String name = column[1];
        String foundationDate = column[2];
        long capital = Long.parseLong(column[3]);
        String country = column[4];

        int headquarterId;
        try {
            headquarterId = Integer.parseInt(column[5]);
        } catch (IndexOutOfBoundsException e) {
            headquarterId = -1;
        }

        Company company = new Company.CompanyBuilder(id)
                .setName(name)
                .setFoundationDate(foundationDate)
                .setCapital(capital)
                .setCountry(country)
                .setHeadquarterId(headquarterId)
                .build();

        return company;

    }

}
