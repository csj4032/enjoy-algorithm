package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkTest {

    @Test
    public void test() {
        Park park = new Park();
        Assertions.assertEquals(3, park.solution(new int[]{5, 3, 2}, new String[][]{
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        }));
    }
}
