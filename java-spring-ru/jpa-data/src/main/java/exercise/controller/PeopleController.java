package exercise.controller;

import exercise.repository.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Person;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Person>> index() {
        List<Person> persons = personRepository.findAll();
        return ResponseEntity
                .ok(persons);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@Valid @RequestBody Person person) {
//        Person person = new Person();
//        person.setFirstName(firstName);
//        person.setLastName(lastName);

        personRepository.save(person);
        return person;
    }

    @GetMapping("/{id}")
    public Person show(@PathVariable long id) {
        return personRepository.findById(id).get();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    void destroy(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

}
