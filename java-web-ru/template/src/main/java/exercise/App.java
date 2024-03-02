package exercise;

import io.javalin.Javalin;

import java.util.*;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;

import java.util.stream.Collectors;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();
    private static List<User> selectUsers = USERS.stream()
            .sorted(Comparator.comparing(User::getId))
            .collect(Collectors.toList());
    public static Javalin getApp() {


        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var header = "Список всех юзеров";


            UsersPage page = new UsersPage(selectUsers, header);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var header = "Страницы конкретного юзера";
            var userNumber = ctx.pathParamAsClass("id", Integer.class).get();

            if (userNumber > USERS.size() || userNumber < 0) {
                throw new NotFoundResponse("Company not found");
            }
            var id = selectUsers.get(userNumber - 1).getId();
            var first = selectUsers.get(userNumber - 1).getFirstName();
            var last = selectUsers.get(userNumber - 1).getLastName();
            var email = selectUsers.get(userNumber -1).getEmail();
            var resultUser = new User(id, first, last, email);

            UserPage page = new UserPage(resultUser, header);
            ctx.render("users/show.jte", Collections.singletonMap("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
