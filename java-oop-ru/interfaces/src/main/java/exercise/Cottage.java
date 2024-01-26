package exercise;

public class Cottage implements Home{
    private double area;
    private int floorCount;

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public Integer compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        } else if (getArea() < another.getArea()) {
            return  -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return floorCount
                + " этажный коттедж площадью "
                + area
                + " метров";
    }
}
