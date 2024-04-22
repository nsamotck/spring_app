package org.example;

public class ContactChecker {
    public static final String CONTACT_FORMAT_INFO = "ФИО;номер телефона;адрес электронной почты";

    private static final String INPUT_MATCHER = ".+;.+;.+$";
    private static final String PHONE_MATCHER = "(\\+*)\\d+";
    private static final String EMAIL_MATCHER = ".+@\\w+\\.[a-z]+$";

    public static boolean isContactInputCorrect(String input) {
        String[] inputSpl = input.split(";");
        return isWholeInputCorrect(input) && isPhoneCorrect(inputSpl[1]) && isEmailCorrect(inputSpl[2]);
    }

    private static boolean isWholeInputCorrect(String input) {
        boolean result = input.matches(INPUT_MATCHER);
        if (!result) {
            System.out.println("Неверный формат входных данных!");
        }
        return result;
    }

    private static boolean isPhoneCorrect(String phone) {
        boolean result = phone.matches(PHONE_MATCHER);
        if (!result) {
            System.out.println("Неверный формат телефона, телефон должен состоять из цифр, предваряться (не обязательно) знаком \"+\"");
        }
        return result;
    }

    private static boolean isEmailCorrect(String email) {
        boolean result = email.matches(EMAIL_MATCHER);
        if (!result) {
            System.out.println("Неверный формат имейла!");
        }
        return result;
    }
}
