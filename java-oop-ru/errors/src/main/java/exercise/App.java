package exercise;

public class App {
    public static void printSquare(Circle circle) {
        int square;
        try {
            square = (int) Math.round(circle.getSquare());
            System.out.println(square);
        } catch (NegativeRadiusException negativeRadiusException){
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
