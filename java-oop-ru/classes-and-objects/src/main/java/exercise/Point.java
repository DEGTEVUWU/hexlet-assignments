package exercise;

public class Point {
    private int X;
    private int Y;

    Point(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
    Point(){

    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "Point{"
                + "X = "
                + X
                + " Y = "
                + Y
                + "}";
    }
}