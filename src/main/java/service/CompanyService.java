package service;

import dao.CompanyDao;
import model.Company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyService {
    List<Company> companies;
    CompanyDao companyDao;

    public CompanyService(String stringPath) {
        companyDao = new CompanyDao();
        companies = companyDao.readData(stringPath);
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public long getTotalCapitalByCountry(String country) {
        long totalCapital = 0;

        totalCapital = this.companies.stream()
                .filter(c -> c.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.summingLong(Company::getCapital));

        return totalCapital;
    }

    public void printCompaniesNameByCountry(String country) {
        this.companies.stream()
                .filter(c -> c.getCountry().equalsIgnoreCase(country))
                .sorted(Comparator.comparing(Company::getCapital).reversed())
                .forEach(c -> System.out.println("||" + c.getName()));
    }

    public void watchForFile(String stringPath) {
        Path path = Paths.get(stringPath);

        while (true) {
            if (Files.exists(path)) {
                companies = companyDao.readData(stringPath);
                break;
            }
        }
    }

}
