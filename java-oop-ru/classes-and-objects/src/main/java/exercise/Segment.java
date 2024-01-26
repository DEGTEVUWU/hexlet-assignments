package exercise;

public class Segment {
    private final Point point1;
    private final Point point2;
    private Point midPoint;

    Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public Point getBeginPoint() {
        return point1;
    }
    public Point getEndPoint() {
        return point2;
    }

    public Point getMidPoint() {
        int diffX = Math.abs(point2.getX() - point1.getX()) / 2 ;
        int diffY = Math.abs(point2.getY() - point1.getY()) / 2;

        int newX;
        int newY;
        if (point1.getX() > point2.getX()) {
            newX = point2.getX() + diffX;
        } else {
            newX = point2.getX() - diffX;
        }
        if (point1.getY() > point2.getY()) {
            newY = point2.getY() + diffY;
        } else {
            newY = point2.getY() - diffY;
        }
        midPoint = new Point(newX, newY);
        return midPoint;
    }


    @Override
    public String toString() {
        return "Segment{"
                + "point1 = "
                + point1.toString()
                + " point2 = "
                + point2.toString()
                + " Middle point + = "
                + midPoint
                + "}";
    }
}