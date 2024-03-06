package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    //маршрут всех пользователей
    public static String postsPath() {
        return "/posts";
    }
    // преобразование айди юзера в строку
    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    //маршрут для конкретного юзера
    public static String postPath(String id) {
        return "/posts/" + id;
    }
    // END
}
