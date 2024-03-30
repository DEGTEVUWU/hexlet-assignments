package exercise.controller.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> index(@PathVariable int id) {
        List<Post> result = posts.stream()
                .filter(p -> p.getUserId() == id)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(result);
    }

    //создание нового поста
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> create(
            @RequestBody Post post,
            @PathVariable int id) {

        post.setUserId(id);
        posts.add(post);
        HttpStatus status = HttpStatus.CREATED;

        return ResponseEntity
                .status(status)
                .body(post);
    }

}
// END
