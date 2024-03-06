package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


// BEGIN
@AllArgsConstructor
@Getter
@Setter
public class PostsPage {
    private List<Post> postsList;
    private String pageNumber;
}
// END


