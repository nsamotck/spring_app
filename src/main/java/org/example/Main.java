package org.example;

import org.example.config.DefaultAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import static org.example.CMDSwitches.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Инициализация...");
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);
        Worker worker = context.getBean(Worker.class);
        ProfileWorker profileWorker = worker.getProfileWorker();
        profileWorker.init();
        ContactsHandler contactsHandler = worker.getContactsHandler();

        Map<String, String> cmdSwitches = getCMDSwitchesMap();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Добро пожаловать в приложение \"Контакты\"");
            System.out.println("Список доступных опций для работы с приложением можно получить через команду " + CMD_HELP);
            System.out.println("______________________________________________________________________________________");

            String inputLine;
            boolean continueLoop = true;
            while (continueLoop) {
                System.out.println("Выберите нужную вам опцию:");
                inputLine = reader.readLine();

                switch (inputLine) {
                    case CMD_EXIT:
                        continueLoop = false;
                        break;
                    case CMD_HELP:
                        cmdSwitches.keySet().forEach(k -> System.out.println(k + " - " + cmdSwitches.get(k)));
                        System.out.println();
                        break;
                    case CMD_ADD:
                        System.out.printf("Введите данные контакта в формате \"%s\":\n", ContactChecker.CONTACT_FORMAT_INFO);
                        String contactData = reader.readLine();
                        if (ContactChecker.isContactInputCorrect(contactData)) {
                            String[] contactSpl = contactData.split(";");
                            contactsHandler.addContact(new Contact(contactSpl[0], contactSpl[1], contactSpl[2]));
                            System.out.println("Контакт успешно добавлен\n");
                        }
                        System.out.println();
                        break;
                    case CMD_SHOW:
                        contactsHandler.showContacts();
                        System.out.println();
                        break;
                    case CMD_DELETE:
                        System.out.println("Введите e-mail контакта, который хотите удалить:");
                        String contactEmail = reader.readLine();
                        if (contactsHandler.deleteContactByEmail(contactEmail)) {
                            System.out.println("Контакт удалён\n");
                        } else {
                            System.out.printf("Контакт с e-mail %s не найден в списке%n", contactEmail);
                            System.out.println();
                        }
                        break;
                    case CMD_SAVE_TO_FILE:
                        contactsHandler.writeContactsToCSV();
                        System.out.println("Список контактов сохранён в файл\n");
                        break;
                    default:
                        System.out.printf("Неизвестная опция \"%s\", для ознакомления с действующими опциями используйте %s%n", inputLine, CMD_HELP);
                        System.out.println();
                }
            }
        }
    }

    private static Map<String, String> getCMDSwitchesMap() {
        Map<String, String> cmdSwitches = new TreeMap<>();
        cmdSwitches.put(CMD_HELP, "получить список опций для работы с приложением");
        cmdSwitches.put(CMD_EXIT, "выйти из приложения");
        cmdSwitches.put(CMD_ADD, String.format("добавить контакт в формате \"%s\"", ContactChecker.CONTACT_FORMAT_INFO));
        cmdSwitches.put(CMD_SAVE_TO_FILE, "сохранить имеющиеся контакты в файл");
        cmdSwitches.put(CMD_SHOW, "показать список всех имеющихся контактов");
        cmdSwitches.put(CMD_DELETE, "удалить контакт по его email");
        return cmdSwitches;
    }
}