package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Worker {

    private final ContactsHandler contactsHandler;

    @Autowired
    public Worker(ContactsHandler contactsHandler) {
        this.contactsHandler = contactsHandler;
    }

    public ContactsHandler getContactsHandler() {
        return contactsHandler;
    }
}
