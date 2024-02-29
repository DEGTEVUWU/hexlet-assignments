import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void TestSum () {
        int result1 = App.sum(1, 9);
        var a = assertThat(result1).isEqualTo(10);
        System.out.println(a);
    }

}
