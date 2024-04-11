package org.example;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

@Component
public class ContactsHandler {
    private static final String RUNTIME_CONTACTS_FILE = "csv/runtime-contacts.csv";

    private final Set<Contact> contacts = new HashSet<>();

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void showContacts() {
        System.out.println(contacts);
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
                ClassLoader.getSystemResource(RUNTIME_CONTACTS_FILE).toURI());
        CSVUtils.writeBeansToCsv(
                pathToSave,
                contacts.stream().toList()
        );
    }
}
