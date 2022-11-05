package ru.job4j.early;

/**
 * @author Shegai Evgenii
 * @since 1.0
 * @version 1.0
 * Проверка пароля
 */

public class PasswordValidator {

    public static String validate(String password) {
       if (password == null) {
           throw new IllegalArgumentException("Password can't be null");
       }
       if (password.length() < 8 || password.length() > 32) {
           throw new IllegalArgumentException("Password should be length [8, 32]");
       }
       if (isStringContainSubstring(password)) {
           throw  new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
       }

        char[] array = password.toCharArray();
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        boolean notDigitOrLetter = false;

        for (char tmp : array) {
            if (Character.isUpperCase(tmp)) {
                upper = true;
            }
            if (Character.isLowerCase(tmp)) {
                lower = true;
            }
            if (Character.isDigit(tmp)) {
                digit = true;
            }
            if (tmp >= 33 && tmp <= 47) {
                notDigitOrLetter = true;
            }
        }
        if (!upper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!digit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!notDigitOrLetter) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }

    private static boolean isStringContainSubstring(String value) {
        value = value.toLowerCase();
        if (value.contains("qwerty") || value.contains("1234") || value.contains("password")
                || value.contains("admin") || value.contains("user")) {
            return true;
        }
        return false;
    }

   /* private static  boolean filter(String value, Predicate<Character> predicate) {
        char[] array = value.toCharArray();
        for (char temp : array) {
            if (predicate.test(temp)) {
                return false;
            }
        }
        return true;
    }*/

}
