package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Worker worker = context.getBean(Worker.class);
        ContactsHandler contactsHandler = worker.getContactsHandler();

        contactsHandler.saveContact(new Contact("snn", "+7999", "@gmail"));
        contactsHandler.saveContact(new Contact("nam", "+7911", "@mail"));
        contactsHandler.saveContact(new Contact("nams", "+7920", "@mail.com"));
        contactsHandler.showContacts();

        System.out.println(contactsHandler.deleteContactByEmail("@mail.com"));
        System.out.println(contactsHandler.deleteContactByEmail("@mail.ru"));

        contactsHandler.showContacts();
    }
}