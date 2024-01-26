package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class App {
    public static void swapKeyValue(KeyValueStorage dictionary) {

        for (Map.Entry<String, String> entry : dictionary.toMap().entrySet()) {
            dictionary.unset(entry.getKey());
            dictionary.set(entry.getValue(), entry.getKey());
        }
    }
}

