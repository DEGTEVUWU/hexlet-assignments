package exercise;

public class ReversedSequence implements CharSequence {
    private String str;

    ReversedSequence(String str) {
        this.str = str;
    }

    public String reverse() {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reverse().substring(start, end);
    }

    @Override
    public String toString() {
        return reverse();
    }

}
