package model;

import java.time.LocalDate;

public class Company {
    private int id;
    private String name;
    private LocalDate foundationDate;
    private String capital;
    private String country;
    private int headquarterId;

    public Company() {
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
}
