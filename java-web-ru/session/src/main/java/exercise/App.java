package exercise;

import exercise.dto.MainPage;
import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;

import java.util.Collections;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), SessionsController::root);
        app.get(NamedRoutes.buildSessionPath(), SessionsController::buildSession);
        app.post(NamedRoutes.loginPath(), SessionsController::login);
        app.post(NamedRoutes.logoutPath(), SessionsController::logout); //app.delete ?


        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
