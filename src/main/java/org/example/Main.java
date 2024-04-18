package org.example;

import org.example.config.DefaultAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);

        Worker worker = context.getBean(Worker.class);
        ProfileWorker profileWorker = worker.getProfileWorker();
        profileWorker.init();
        ContactsHandler contactsHandler = worker.getContactsHandler();
        System.out.println("Contacts after init: " + contactsHandler.getContacts());

        contactsHandler.saveContact(new Contact("snn", "+7999", "@gmail"));
        contactsHandler.saveContact(new Contact("nam", "+7911", "@mail"));
        contactsHandler.saveContact(new Contact("nams", "+7920", "@mail.com"));
        contactsHandler.showContacts();

        System.out.println(contactsHandler.deleteContactByEmail("@mail.com"));
        System.out.println(contactsHandler.deleteContactByEmail("@mail.ru"));

        contactsHandler.saveContact(new Contact("namssss", "+7921", "@gmail.com"));
        contactsHandler.showContacts();
        contactsHandler.writeContactsToCSV();
    }
}