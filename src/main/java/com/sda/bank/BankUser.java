package com.sda.bank;

import java.util.Objects;

public class BankUser {
    private String name;
    private String pesel;

    public BankUser(String name, String pesel) {
        this.name = name;
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankUser bankUser = (BankUser) o;
        return Objects.equals(name, bankUser.name) &&
                Objects.equals(pesel, bankUser.pesel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, pesel);
    }
}
