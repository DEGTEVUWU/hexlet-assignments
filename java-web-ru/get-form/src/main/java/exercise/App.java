package exercise;

import io.javalin.Javalin;

import java.util.*;
import java.util.stream.Collectors;

import exercise.model.User;
import exercise.dto.users.UsersPage;
import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users = new ArrayList<>();

            if (term != null) {
//                Set<String> namesUsers = new TreeSet<>();
//                namesUsers = USERS.stream()
//                        .map(User::getFirstName)
//                        .collect(Collectors.toSet());
//
//
//                boolean nameExist = false;
//                for (var name : namesUsers) {
//                    if (name.equals(term)) {
//                        nameExist = true;
//                    }
//                }
//
//                if (nameExist) {
                        users = USERS.stream()
                            .filter(c  -> startsWithIgnoreCase(c.getFirstName(), term))
                                    .collect(Collectors.toList());
                    //users.add(user);
            } else {
                users = USERS;
            }
            UsersPage page = new UsersPage(users, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));

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
