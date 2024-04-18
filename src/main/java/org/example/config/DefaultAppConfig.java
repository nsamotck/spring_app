package org.example.config;

import org.example.InitContactsDefault;
import org.example.contract.ContactsInitializer;
import org.springframework.context.annotation.*;

@ComponentScan("org.example")
@Configuration
@PropertySource("classpath:application.properties")
public class DefaultAppConfig {

    @Bean
    @Profile("default")
    public ContactsInitializer contactsInitializer() {
        return new InitContactsDefault();
    }
}
