package org.example;

import org.example.utils.CSVUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

@Component
public class ContactsHandler {

    private final Set<Contact> contacts = new HashSet<>();
    @Value("${contacts.runtime.file}")
    private String contactsFileName;

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void showContacts() {
        contacts.stream().sorted(Comparator.comparing(Contact::getFullName)).forEach(System.out::println);
    }

    /***
     * Removes all found contacts with given email
     * @param email
     * @return - true if any Contact was removed
     */
    public boolean deleteContactByEmail(String email) {
        return contacts.removeIf(contact -> contact.getEmail().equals(email));
    }

    /***
     * Writes all available contacts to CSV using default file location
     * @throws Exception
     */
    public void writeContactsToCSV() throws Exception {
        Path pathToSave = Paths.get(
                ClassLoader.getSystemResource(contactsFileName).toURI());
        CSVUtils.writeBeansToCsv(
                pathToSave,
                contacts.stream().toList()
        );
    }
}
