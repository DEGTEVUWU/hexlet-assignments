package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.exception.ResourceAlreadyExistsException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "")
    public List<Product> index() {
        return productRepository.findAll();
    }

    // BEGIN
//    @PostMapping(path = "")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Product create(@RequestBody Product product) {
//        Optional<Product> maybyProduct = productRepository.findAll()
//                .stream()
//                .filter(p -> p.getPrice().equals(product.getPrice()))
//                .filter(p -> p.getTitle().equals(product.getTitle()))
//                .findFirst();
//        if (maybyProduct.isPresent()) {
//            throw new ResourceAlreadyExistsException("Product with price " + product.getPrice() + " and title "
//                    + product.getTitle() + " already exist");
//        }
//        return productRepository.save(product);
//    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        List<Product> m = productRepository.findAllById(Collections.singleton(product.getId()));
        if (!m.isEmpty()) {
//            return ResponseEntity.status(409).body( new ResourceAlreadyExistsException("Error!"));
            throw new ResourceAlreadyExistsException("Error!");
        }
        return ResponseEntity.status(201).body(productRepository.save(product));
    }

//    @PostMapping(path = "")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Product create(@RequestBody Product product) {
//        boolean product2 = productRepository.findById(product.getId())
//                .isPresent();
//        if (product2) {
//            throw new ResourceAlreadyExistsException("E!");
//        }
//        return productRepository.save(product);
//    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {
        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }

    @PutMapping(path = "/{id}")
    public Product update(@PathVariable long id, @RequestBody Product productData) {
        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        product.setTitle(productData.getTitle());
        product.setPrice(productData.getPrice());

        productRepository.save(product);

        return product;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        productRepository.deleteById(id);
    }
}
