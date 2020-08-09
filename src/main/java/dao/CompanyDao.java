package dao;

import model.Company;
import utils.CSVReader;
import utils.FileReader;
import utils.ModelFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompanyDao {

    private FileReader fileReader;

    public CompanyDao() {
        this.fileReader = new CSVReader();
    }


    public List<Company> readData(String stringPath) {
        List<Company> companies = new ArrayList<>();

        try {
            Stream<String> lines = fileReader.getFileStream(stringPath);
            String jointRowsData = lines.collect(Collectors.joining("\n"));

            String[] arrayOfString = jointRowsData.split("\n");

            for (int i = 1; i < arrayOfString.length; i++) {
                companies.add(convertStringToCompany(arrayOfString[i]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return companies;

    }

    private Company convertStringToCompany(String stringCompany) {
        int id;
        String name;
        String foundationDate;
        long capital;
        String country;
        int headquarterId;

        String[] column = stringCompany.split(",");

        id = Integer.parseInt(column[0]);
        name = column[1];
        foundationDate = column[2];
        capital = Long.parseLong(column[3]);
        country = column[4];

        try {
            headquarterId = Integer.parseInt(column[5]);
        } catch (IndexOutOfBoundsException e) {
            headquarterId = -1;
        }

        return ModelFactory.createCompany(id, name, foundationDate, capital, country, headquarterId);

    }

}
