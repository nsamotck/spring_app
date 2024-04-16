package org.example.config;

import org.example.contract.ContactsInitializer;
import org.example.InitContacts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-init.properties")
@Profile("init")
public class InitAppConfig {

    @Bean
    public ContactsInitializer contactsInitializer() {
        return new InitContacts();
    }
}
