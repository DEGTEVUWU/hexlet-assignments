package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    //маршрут для всех постов
    public static String postsPath() {
        return "/posts";
    }

    //маршрут для конкретного поста
    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    //маршрут для конкретного поста
    public static String postPath(String id) {
        return "/posts/" + id;
    }
    // END
}
