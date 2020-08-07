package service;

import dao.CompanyDao;
import model.Company;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyService {
    List<Company> companies;
    CompanyDao companyDao;

    public CompanyService(String stringPath) {
        companyDao = new CompanyDao();
        this.companies = companyDao.readFile(stringPath);

        companyDao.readData(stringPath);
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public long getTotalCapitalByCountry(String country) {
        long totalCapital = 0;

        totalCapital = this.companies.stream()
                .filter(c -> c.getCountry().equalsIgnoreCase("CH"))
                .collect(Collectors.summingLong(Company::getCapital));

        return totalCapital;
    }

    public void printCompaniesNameByCountry() {
        this.companies.stream()
                .filter(c -> c.getCountry().equalsIgnoreCase("CH"))
                .sorted(Comparator.comparing(Company::getCapital).reversed())
                .forEach(c -> System.out.println("||" + c.getName()));
    }

}
