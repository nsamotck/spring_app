package org.example;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Component
public class ContactsHandler {
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
}
