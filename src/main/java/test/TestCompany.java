package test;

import service.CompanyService;

public class TestCompany {

    public static void main(String[] args) {
//        String s = "D:\\Projects\\JAVA-1.1.Exercise\\company.csv";
//        String s = "D:\\Projects\\JAVA-1.1.Exercise\\companies_big_data.csv";
        String s = "D:\\Intellij Workspace\\company.csv";

        CompanyService companyService = new CompanyService(s);

        System.out.println("Feature 2:");
        companyService.printCompaniesNameByCountry("CH");
        System.out.println("\nnFeature 3:");
        System.out.println(companyService.getTotalCapitalByCountry("CH"));

        System.out.println("\nnFeature 4 & 5:");
        s = "D:\\Intellij Workspace\\companies_big_data.csv";
        companyService.watchForFile(s);
        System.out.println(companyService.getCompanies());

//        System.out.println("\nnFeature 5:");
//
//        companyService.reloadData(s);
//
    }
}
