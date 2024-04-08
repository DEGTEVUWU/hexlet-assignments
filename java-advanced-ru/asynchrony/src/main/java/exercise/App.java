package exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String path1, String path2, String resultPath) {

        try {
            Files.exists(Path.of(path1));
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Files.exists(Path.of(path2));
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }


        CompletableFuture<String> readFirstFile = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(path1));
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        });

        CompletableFuture<String> readSecondFile = CompletableFuture.supplyAsync(() -> {
            try {
                 return Files.readString(Path.of(path2));
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        });


        return readFirstFile.thenCombine(readSecondFile, (first, second) -> {
            String resultString  = first + second;
            try {
                Files.write(Path.of(resultPath), resultString.getBytes());
                System.out.println("Строка успешно записана в файл: " + resultPath);
            } catch (IOException e) {
                System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
            }
            // Обработка исключений
            // Если при работе задач возникли исключения
            // их можно обработать в методе exceptionally
            return resultString;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = App.unionFiles("file1.txt", "file2.txt", "dest.txt");
        System.out.println(result);

        // END
    }
}

