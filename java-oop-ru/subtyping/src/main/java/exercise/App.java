package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import hexlet.code.Validator;

public class App {
    /*
    public static void swapKeyValue(KeyValueStorage dictionary) {

        for (Map.Entry<String, String> entry : dictionary.toMap().entrySet()) {
            dictionary.unset(entry.getKey());
            dictionary.set(entry.getValue(), entry.getKey());
        }
    }

     */
    public static void main(String[] args) {
        //KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        //System.out.println(storage.get("key", "default"));
        //System.out.println(storage.get("key2", "default"));

        var v = new Validator();
        var test = v.number().positive();
        System.out.println(test.isValid(2));


    }
}

