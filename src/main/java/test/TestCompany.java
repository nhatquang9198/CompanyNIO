package test;

import service.CompanyService;

public class TestCompany {

    public static void main(String[] args) {
        String s = "D:\\Projects\\JAVA-1.1.Exercise\\company.csv";

        CompanyService companyService = new CompanyService(s);

        System.out.println("Feature 2:");
        companyService.printCompaniesNameByCountry("CH");
        System.out.println("\nFeature 3:");
        System.out.println(companyService.getTotalCapitalByCountry("CH"));

        System.out.println("\nFeature 4 & 5:");
        s = "D:\\Projects\\JAVA-1.1.Exercise\\companies_big_data.csv";
        companyService.watchForFile(s);
        companyService.getCompanies().stream()
                .limit(5)
                .forEach(System.out::println);
//        System.out.println(companyService.getCompanies());

    }
}
