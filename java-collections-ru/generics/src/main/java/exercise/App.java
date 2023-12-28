package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> generalList, Map<String, String> dictionary) {
        List<Map<String, String>> resultList = new ArrayList<>();
        if (generalList.isEmpty()) {
            return resultList;
        }
        for (var general : generalList) {
            var res11 = general.entrySet().containsAll(dictionary.entrySet());
            if (res11) {
                resultList.add(general);
            }
        }
        return resultList;
    }
}
//END
