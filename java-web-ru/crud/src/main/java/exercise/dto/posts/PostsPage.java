package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


// BEGIN
@Getter
@Setter
@AllArgsConstructor
public class PostsPage {
    private List<Post> postList;
    private Integer pageNumber;
    private Integer previousPage;
    private Integer nextPage;
}
// END


