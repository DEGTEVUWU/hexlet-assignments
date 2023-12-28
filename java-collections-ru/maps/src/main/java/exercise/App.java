package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String string) {
        if (string.length() == 0) {
            Map<String, Integer> i = new HashMap<>();
            return i;
        }
        var words = string.split(" ");
        var worldCount = new HashMap<String, Integer>();

        for (var word : words) {
            var value = worldCount.getOrDefault(word, 0) + 1;
            worldCount.put(word, value);
        }
        return worldCount;

    }

    public static String toString(Map<String, Integer> map) {
        if (map.size() == 0) {
            return "{}";
        }
        String res1 = "{\n";

        for (var map1 : map.keySet()) {
            res1 = res1 +  "  " + map1 + ": " + map.get(map1) + "\n";
        }
        return res1 + "}";
    }
}
//END
