package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

@Getter
@NoArgsConstructor
@AllArgsConstructor
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    public String serialize() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(this);
        return result;
    }
    public static Car unserialize(String js) throws IOException {
        Car resultCar = new Car();
        ObjectMapper mapper = new ObjectMapper();
        resultCar = mapper.readValue(js, Car.class);
        return  resultCar;
    }

}
