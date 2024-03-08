package exercise.controller;

import java.util.*;
import java.util.stream.Collectors;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found."));

        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int quantity = 5;
        int begin = (pageNumber - 1) * quantity;
        int end = begin + quantity;
        var posts = PostRepository.getEntities();
        int previousPage = pageNumber == 1 ? 1 : pageNumber - 1;
        int nextPage = pageNumber + 1;
        List<Post> sliceOfPosts;

        if(begin >= posts.size()) {
            sliceOfPosts = new ArrayList<>();
        } else if (end > posts.size()) {
            sliceOfPosts = posts.subList(begin, posts.size());
        } else {
            sliceOfPosts = posts.subList(begin, end);
        }
        var page = new PostsPage(sliceOfPosts, pageNumber, previousPage, nextPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END
}
