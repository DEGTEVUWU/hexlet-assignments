package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import java.util.Collections;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", Collections.singletonMap("page", page));
        });





        app.post("/articles", ctx -> {
            var title = ctx.formParam("title");
            var content = ctx.formParam("content");
            try {
                ctx.formParamAsClass("title", String.class)
                        .check(value -> value.length() > 2, "Название не должно быть короче двух символов")
                        .check(value -> ArticleRepository.getEntities().stream()
                                .noneMatch(art -> art.getTitle().equals(value)),
                                "Статья с таким названием уже существует")
                        .get();

                List<Article> listWithArt = ArticleRepository.getEntities();
                for (var  article : listWithArt) {
                    if (article.getTitle().equals(title)) {
                        title = "Статья с таким названием уже существует";
                    }
                }

                ctx.formParamAsClass("content", String.class)
                        .check(value -> value.length() > 10, "Статья должна быть не короче 10 символов")
                        .get();
                Article article = new Article(title, content);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                var page = new BuildArticlePage(title, content, e.getErrors());
                ctx.status(422).render("articles/build.jte", Collections.singletonMap("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
