package org.example;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ContactsHandler {
    private final Set<Contact> contacts = new HashSet<>();

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void showContacts() {
        System.out.println(contacts);
    }
}
