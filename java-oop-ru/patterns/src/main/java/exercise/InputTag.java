package exercise;

public class InputTag implements TagInterface {
    private String first;
    private String second;
    InputTag(String first, String second) {
        this.first = first;
        this.second = second;
    }
    @Override
    public String render() {
        return "<input type=\"" + first + "\" value=\"" + second + "\">";
    }
    @Override public String toString() {
        return "<input type=\"" + first + "\" value=\"" + second + "\">";
    }
}
