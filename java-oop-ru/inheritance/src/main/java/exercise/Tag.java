package exercise;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Getter
@Setter
public abstract class Tag {
    private  String name;
    private Map<String, String> attributes;
    private String tagsBody;
    private List<Tag> child;

    Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }
    Tag(String name, Map<String, String> attributes, String tagsBody, List<Tag> child) {
        this.name = name;
        this.attributes = attributes;
        this.tagsBody = tagsBody;
        this.child = child;
    }


    public abstract String toString();
}
