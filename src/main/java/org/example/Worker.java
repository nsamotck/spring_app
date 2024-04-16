package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Worker {

    private final ProfileWorker profileWorker;
    private final ContactsHandler contactsHandler;

    @Autowired
    public Worker(ProfileWorker profileWorker, ContactsHandler contactsHandler) {
        this.profileWorker = profileWorker;
        this.contactsHandler = contactsHandler;
    }

    public ContactsHandler getContactsHandler() {
        return contactsHandler;
    }

    public ProfileWorker getProfileWorker() {
        return profileWorker;
    }
}
