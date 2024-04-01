package exercise.controller;

import exercise.Application;
import exercise.daytime.Day;
import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
@RestController
public class WelcomeController {
    @Autowired
    private Daytime daytime;

    @GetMapping(path = "/welcome")
    @ResponseStatus(HttpStatus.OK)
    public String welcome() {
        System.out.println("It is " + daytime.getName() + " night now! Welcome to Spring!");
        return "It is " + daytime.getName() + " night now! Welcome to Spring!";
    }
}
// END
