package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {

        List<String> resultList = new ArrayList<>();
/*
        Collections.sort(apartments, Comparator.comparing(Home::getArea));

        for (var apart : apartments.subList(0, 3)) {
            resultList.add(apart.toString());
        }

 */

        return apartments.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .limit(count)
                .map(Home::toString)
                .collect(Collectors.toList());

    }
}
