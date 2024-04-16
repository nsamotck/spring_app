package org.example;

import org.example.contract.ContactsInitializer;
import org.springframework.beans.factory.annotation.Value;

public class InitContacts implements ContactsInitializer {

    @Value("${app.init.contacts.file_name}")
    private String fileName;

    @Override
    public void initContacts() {
        System.out.println("Hello from InitContacts, file name = " + fileName);
    }
}
