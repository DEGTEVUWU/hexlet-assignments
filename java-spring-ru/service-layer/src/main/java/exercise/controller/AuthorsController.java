package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping(path = "")
    public ResponseEntity<List<AuthorDTO>> index() {
        var authors = authorService.getAll();

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(authors.size()))
                .body(authors);

    }
    @PostMapping(path = "")
    public ResponseEntity<AuthorDTO> create(@Valid @RequestBody AuthorCreateDTO authorData) {
        AuthorDTO author = authorService.create(authorData);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(author);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<AuthorDTO> show(@PathVariable Long id) {
        AuthorDTO author = authorService.findById(id);

        return ResponseEntity.ok()
                .body(author);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<AuthorDTO> update(@Valid @RequestBody AuthorUpdateDTO authorData, @PathVariable Long id) {
        AuthorDTO author = authorService.update(authorData, id);

        return ResponseEntity.ok()
                .body(author);
    }
    @DeleteMapping(path = "")
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        authorService.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
    // END
}
