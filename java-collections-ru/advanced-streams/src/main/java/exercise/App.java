package exercise;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static void main(String[] args) throws IOException {
        String content = Files.readString(Path.of("s2.conf"));

        String result = App.getForwardedVariables(content);
        System.out.println(result); // => "MAIL=tirion@google.com,HOME=/home/tirion,var3=value"
    }


    public static String getForwardedVariables (String configFileContent) {
        List<String> lines = Arrays.asList(configFileContent.split("\n"));
        String result = lines.stream()
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.split("\"")[1])
                .flatMap(envString ->Arrays.stream(envString.split(",")))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

        return result;

    }










/*

    public static String getForwardedVariables(String configFileContent) {

        List<String> lines = Arrays.asList(configFileContent.split("\n"));

        String result = lines.stream()
                .filter(line -> line.contains("environment="))
                .map(line -> line.split("\"")[1])
                .flatMap(envString -> Arrays.stream(envString.split(",")))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

        return result;
    }


 */
}
//END
