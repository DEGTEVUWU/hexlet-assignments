package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });


        app.get("/users", ctx -> {
            List<Map<String, String>> outputList = new ArrayList<>();
            var pade = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            int indexForStartCicl = pade * per - per;
            int indexForFinishCicl = pade * per;
            while (indexForStartCicl < indexForFinishCicl) {
                outputList.add(USERS.get(indexForStartCicl));
                indexForStartCicl++;
            }

            ctx.json(outputList);
        });

        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
