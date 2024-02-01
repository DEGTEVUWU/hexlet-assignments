package exercise;

public class LabelTag implements TagInterface {
    private String first;
    private TagInterface input;
    LabelTag(String first, TagInterface input) {
        this.first = first;
        this.input = input;
    }
    @Override
    public String render() {
        return "<label>" + first + input + "</label>";
    }
}