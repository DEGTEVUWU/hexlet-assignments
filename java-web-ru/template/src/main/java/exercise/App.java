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

    public static Javalin getApp() {
//        var selectUsers = USERS.stream()
//                .sorted(Comparator.comparing(User::getId))
//                .collect(Collectors.toList());

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var header = "Список всех юзеров";
            var selectUsers = USERS.stream()
                    .sorted(Comparator.comparing(User::getId))
                    .collect(Collectors.toList());

            UsersPage page = new UsersPage(selectUsers, header);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var header = "Страницы конкретного юзера";
            var userNumber = ctx.pathParamAsClass("id", Integer.class).get();

            if (userNumber > USERS.size() || userNumber < 0) {
                throw new NotFoundResponse("Company not found");
            }
            var id = USERS.get(userNumber).getId();
            var first = USERS.get(userNumber).getFirstName();
            var last = USERS.get(userNumber).getLastName();
            var email = USERS.get(userNumber).getEmail();
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
