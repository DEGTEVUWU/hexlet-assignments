package exercise;

public class ReversedSequence implements CharSequence {
    private String str;

    ReversedSequence(String text) {
        StringBuilder s  = new StringBuilder(text);
        this.str = s.reverse().toString();
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
        return str.substring(start, end);
    }

    @Override
    public String toString() {
        return str;
    }

}
