package exercise;

public class Flat implements Home{
    private double area;
    private double balconyArea;
    private Integer floor;

    Flat(double area, double balconyArea, Integer floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {

        return area + balconyArea;
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
        return "Квартира площадью "
                + getArea()
                + " метров на "
                + floor
                + " этаже";
    }
}
