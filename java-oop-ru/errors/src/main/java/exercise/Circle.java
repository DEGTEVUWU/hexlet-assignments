package exercise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle {
    private Point point;
    @Getter
    private int radius;
    Circle() {
    }
    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
            return (Math.PI * radius * radius);
    }
}
