package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = new ArrayList<>();
        Integer count = 6;

        for (var i = 0; i < list.size(); i++) {
            result.add(list.get(i));
        }

        var actual1 = App.take(list, count);
        assertThat(actual1).isEqualTo(result);
        // END
    }
}
