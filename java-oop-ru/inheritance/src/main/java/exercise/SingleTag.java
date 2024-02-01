package exercise;

import java.util.Map;

public final class SingleTag extends Tag {

    SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        String result = "<" + getName();
        for (var entry : getAttributes().entrySet()) {
            result += " " + entry.getKey() + "=" + "\"" + entry.getValue() + "\"";
        }
        result += ">";
        return  result;
}
}