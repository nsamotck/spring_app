package org.example;

import org.example.contract.ContactsInitializer;
import org.example.utils.CSVUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InitContacts implements ContactsInitializer {

    @Value("${app.init.contacts.file_name}")
    private String fileName;
    @Autowired
    private ContactsHandler contactsHandler;

    @Override
    public void initContacts() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(fileName).toURI());
        contactsHandler.getContacts().addAll(CSVUtils.readBeansFromCSV(path, Contact.class));
    }
}
