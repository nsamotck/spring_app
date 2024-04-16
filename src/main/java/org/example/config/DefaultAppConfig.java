package org.example.config;

import org.example.InitContactsDefault;
import org.example.contract.ContactsInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("org.example")
@Configuration
@PropertySource("classpath:application.properties")
public class DefaultAppConfig {

    @Bean
    public ContactsInitializer contactsInitializer() {
        return new InitContactsDefault();
    }
}
