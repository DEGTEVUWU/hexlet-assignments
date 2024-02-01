package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public final class PairedTag extends Tag {

    PairedTag(String name, Map<String, String> attributes, String tagsBody, List<Tag> child) {
        super(name, attributes, tagsBody, child);
    }

    @Override
    public String toString() {
        String result = "<" + getName();
        for (var entry : getAttributes().entrySet()) {
            result += " " + entry.getKey() + "=" + "\"" + entry.getValue() + "\"";
        }
        result += ">" + getTagsBody();
        for (var listOne : getChild()) {
            result += listOne.toString();
        }
        result += "</" + getName() + ">";
        return  result;
    }
}
