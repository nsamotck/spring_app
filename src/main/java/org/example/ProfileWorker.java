package org.example;

import org.example.contract.ContactsInitializer;
import org.springframework.stereotype.Component;

@Component
public class ProfileWorker {

    private final ContactsInitializer contactsInitializer;

    public ProfileWorker(ContactsInitializer contactsInitializer) {
        this.contactsInitializer = contactsInitializer;
    }

    public void init() {
        contactsInitializer.initContacts();
    }
}
