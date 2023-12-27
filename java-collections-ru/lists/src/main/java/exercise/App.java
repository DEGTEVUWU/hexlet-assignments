package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String list, String check) {
        int result = 0;

        if (check.length() > list.length()) {
            return false;
        }

        List<String> listWithSumbols = Arrays.asList(list.split(""));
        List<String> listWithCheck = Arrays.asList(check.split(""));

        for (var i = 0; i < listWithSumbols.size(); i++) {
            for (var j = 0; j < listWithCheck.size(); j++) {
                if (listWithCheck.get(j).equalsIgnoreCase(listWithSumbols.get(i))) {
                    listWithCheck.set(j, "");
                    listWithSumbols.set(i, "");
                    result += 1;
                    break;
                }

            }
        }
        if (result == check.length()) {
            return true;
        }
        return  false;

    }
}
//END
