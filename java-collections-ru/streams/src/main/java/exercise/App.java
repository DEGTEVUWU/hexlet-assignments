package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        var a = emails.stream()
                .filter(n -> n.endsWith("gmail.com"))
                .count();
        var a2 = emails.stream()
                .filter(n2 -> n2.endsWith("yandex.ru"))
                .count();
        var a3 = emails.stream()
                .filter(n3 -> n3.endsWith("hotmail.com"))
                .count();
        return (int) (a + a2 + a3);
    }
}

// END
