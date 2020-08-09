package model;

public class Company {
    private int id;
    private String name;
    private String foundationDate;
    private long capital;
    private String country;
    private int headquarterId;

    public Company(CompanyBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.foundationDate = builder.foundationDate;
        this.capital = builder.capital;
        this.country = builder.country;
        this.headquarterId = builder.headquarterId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFoundationDate() {
        return foundationDate;
    }

    public long getCapital() {
        return capital;
    }

    public String getCountry() {
        return country;
    }

    public int getHeadquarterId() {
        return headquarterId;
    }

    @Override
    public String toString() {
        return "model.Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foudationDate=" + foundationDate +
                ", capital='" + capital + '\'' +
                ", country='" + country + '\'' +
                ", headquarterId=" + headquarterId +
                '}';
    }

    public static class CompanyBuilder {
        private int id;
        private String name;
        private String foundationDate;
        private long capital;
        private String country;
        private int headquarterId;

        public CompanyBuilder(int id) {
            this.id = id;
        }

        public CompanyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CompanyBuilder setFoundationDate(String foundationDate) {
            this.foundationDate = foundationDate;
            return this;
        }

        public CompanyBuilder setCapital(long capital) {
            this.capital = capital;
            return this;
        }

        public CompanyBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public CompanyBuilder setHeadquarterId(int headquarterId) {
            this.headquarterId = headquarterId;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }
}
