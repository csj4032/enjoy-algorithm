package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DottingTest {

    @Test
    public void test() {
        Dotting dotting = new Dotting();
        Assertions.assertEquals(3, dotting.solution(1, 1));
        Assertions.assertEquals(6, dotting.solution(1, 2));
        Assertions.assertEquals(11, dotting.solution(1, 3));
        Assertions.assertEquals(17, dotting.solution(1, 4));
        Assertions.assertEquals(26, dotting.solution(1, 5));
        Assertions.assertEquals(35, dotting.solution(1, 6));
        Assertions.assertEquals(45, dotting.solution(1, 7));
        Assertions.assertEquals(58, dotting.solution(1, 8));
        Assertions.assertEquals(73, dotting.solution(1, 9));
        Assertions.assertEquals(90, dotting.solution(1, 10));
        Assertions.assertEquals(106, dotting.solution(1, 11));
        Assertions.assertEquals(123, dotting.solution(1, 12));
        Assertions.assertEquals(146, dotting.solution(1, 13));
    }
}