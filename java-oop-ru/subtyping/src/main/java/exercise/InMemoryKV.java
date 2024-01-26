package exercise;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class InMemoryKV implements KeyValueStorage {

    private Map<String, String> map;

    public InMemoryKV(Map<String, String> map) {
        this.map = new HashMap<>(map);
    }
    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }
    @Override
    public void unset(String key) {
        map.remove(key);
    }
    @Override
    public String get(String key, String def) {
        return  map.getOrDefault(key, def);
    }
    @Override
    public Map<String, String> toMap() {
        //Map<String, String> map2 = map;
        //return map2;

        return new TreeMap<>(map);
    }

}
