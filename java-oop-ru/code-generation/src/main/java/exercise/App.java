package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;


public class App {
    public static void main(String[] args) throws IOException {
        User user1 = new User(1, "Iv", "De", 26);
        Car car1 = new Car(1, "bmv", "x5", "black", user1);
        String test1 = car1.serialize();
        System.out.println(test1);

        System.out.println("");

        Car result = Car.unserialize(test1);
        System.out.println(result.getBrand());
        System.out.println(result.getModel());

        System.out.println("");

        Path path1 = Paths.get("/tmp/file1.json");
        Car car2 = new Car(1, "audi", "q3", "black", user1);
        App.save(path1, car2); // Сохраняет представление объекта в файл

        Path path2 = Paths.get("/tmp/file1.json");
        Car car3 = App.extract(path2); // Возвращает инстанс класса Car
        System.out.println(car3.getModel()); // "passat"
    }

    public static void save(Path filePath, Car car) throws IOException {
        String dataObject = car.serialize();
        Files.write(filePath, Collections.singleton(dataObject));
    }
    public static Car extract(Path filePath) throws IOException {
        String jsonData = Files.readString(filePath).trim();
        Car resultCar =  Car.unserialize(jsonData);
        return resultCar;
    }
}
