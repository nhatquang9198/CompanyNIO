package test;

import service.CompanyService;

public class TestCompany {

    public static void main(String[] args) {
//        String s = "D:\\Projects\\JAVA-1.1.Exercise\\company.csv";
        String s = "D:\\Projects\\JAVA-1.1.Exercise\\companies_big_data.csv";

        CompanyService companyService = new CompanyService(s);

        System.out.println("Feature 1:");
        companyService.printCompaniesNameByCountry();
        System.out.println("\nnFeature 2:");
        System.out.println(companyService.getTotalCapitalByCountry("CH"));
    }
}
