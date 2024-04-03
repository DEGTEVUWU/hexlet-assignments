package exercise.controller;

import exercise.dto.CommentDTO;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        List<Post> posts = postRepository.findAll();
        List<PostDTO> result = posts.stream()
                .map(this::toDTO)
                .toList();
        return result;
    }


    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable Long id) {
        Post post =  postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var dto = toDTO(post);
        return dto;
    }

    private PostDTO toDTO(Post post) {
        var dto = new PostDTO();
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        List<CommentDTO> commentDTOS = new ArrayList<>();
        CommentDTO commentDTO = new CommentDTO();
        for (var comment : comments) {
            commentDTO.setId(comment.getId());
            commentDTO.setBody(comment.getBody());
            commentDTOS.add(commentDTO);
        }

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setBody(post.getBody());
        dto.setComments(commentDTOS);

        return dto;
    }
}
// END
