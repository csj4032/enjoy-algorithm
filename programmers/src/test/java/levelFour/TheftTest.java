package levelFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TheftTest {

    @Test
    public void test() {
        Theft theft = new Theft();
        Assertions.assertEquals(3, theft.solution(new int[]{1, 2, 3}));
        Assertions.assertEquals(8, theft.solution(new int[]{1, 2, 3, 1, 5}));
        Assertions.assertEquals(6, theft.solution(new int[]{1, 5, 3, 1}));
        Assertions.assertEquals(8, theft.solution(new int[]{1, 5, 7, 1}));
    }
}