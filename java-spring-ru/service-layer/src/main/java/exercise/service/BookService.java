package exercise.service;

import exercise.dto.AuthorDTO;
import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Author;
import exercise.model.Book;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        var books = repository.findAll();
        var result = books.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO create(BookCreateDTO bookData) {
        try {
            Book book = bookMapper.map(bookData);
            var author = authorRepository.findById(bookData.getAuthorId()).get();
            book.setAuthor(author);
            repository.save(book);
            var bookDTO = bookMapper.map(book);
            return bookDTO;
        } catch(NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }

    public BookDTO findById(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO update(BookUpdateDTO bookData, Long id) {
        try {
            var book = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
//        var author = authorRepository.findById(id)
//                        .orElseThrow(() -> new ResourceNotFoundException("Not Found"));

            bookMapper.update(bookData, book);;
            repository.save(book);
            var bookDTO = bookMapper.map(book);
//        bookDTO.setAuthorFirstName(author.getFirstName());
//        bookDTO.setAuthorLastName(author.getLastName());
            return bookDTO;
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
