package service;

import dao.CompanyDAO;
import model.Company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CompanyService {
    private List<Company> companies;
    private CompanyDAO companyDAO;

    public CompanyService(List<Company> companies) {
        this.companies = new ArrayList<>();
        this.companyDAO = new CompanyDAO();
    }

    public List<Company> readFile(String stringPath){
        Path filePath = Paths.get(stringPath);
        BufferedReader reader = companyDAO.readFile(filePath);


        return null;
    }
}
