package org.example;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class Contact implements CSVBean {

    @CsvBindByPosition(position = 0)
    private String fullName;

    @CsvBindByPosition(position = 1)
    private String phoneNumber;

    @CsvBindByPosition(position = 2)
    private String email;

    public Contact(String fullName, String phoneNumber, String email) {
        System.out.println("Initializing contact...");
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s", getFullName(), getPhoneNumber(), getEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(fullName, contact.fullName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber, email);
    }
}
