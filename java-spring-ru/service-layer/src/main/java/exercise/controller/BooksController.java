package exercise.controller;

import java.util.List;

import exercise.dto.*;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookDTO>> index() {
        var books = bookService.getAll();

        return ResponseEntity.ok()
                .body(books);
    }
    @PostMapping(path = "")
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookCreateDTO bookData) {
        BookDTO book = bookService.create(bookData);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(book);
    }
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> show(@PathVariable Long id) {
        BookDTO book = bookService.findById(id);

        return ResponseEntity.ok()
                .body(book);
    }
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookDTO> update(@Valid @RequestBody BookUpdateDTO bookData, @PathVariable Long id) {
        BookDTO book = bookService.update(bookData, id);

        return ResponseEntity.ok()
                .body(book);
    }
    @DeleteMapping(path = "")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        bookService.delete(id);

        return ResponseEntity.noContent()
                .build();
    }
    // END
}
