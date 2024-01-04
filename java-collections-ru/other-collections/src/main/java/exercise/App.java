package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        LinkedHashMap<String, String> resultMap = new LinkedHashMap<>();

        var res1 = firstMap.keySet();
        var res2 = secondMap.keySet();
        TreeSet<String> resultSet = new TreeSet<>();
        resultSet.addAll(res1);
        resultSet.addAll(res2);

        for (var key : resultSet) {
            if (firstMap.containsKey(key) && !(secondMap.containsKey(key))) {
                resultMap.put(key, "deleted");
            }
            if (!(firstMap.containsKey(key)) && secondMap.containsKey(key)) {
                resultMap.put(key, "added");
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key) && !(firstMap.get(key).equals(secondMap.get(key)))) {
                resultMap.put(key, "changed");
            }
            if (firstMap.containsKey(key) && secondMap.containsKey(key) && firstMap.get(key).equals(secondMap.get(key)))
                resultMap.put(key, "unchanged");
        }
        return resultMap;
    }
}
//END
