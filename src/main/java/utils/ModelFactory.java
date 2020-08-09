package utils;

import model.Company;

public class ModelFactory {

    public static Company createCompany(int id, String name, String foundationDate, long capital, String country, int headquarterId) {
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
