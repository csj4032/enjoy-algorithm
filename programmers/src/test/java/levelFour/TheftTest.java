package levelFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TheftTest {

    @Test
    public void test() {
        Theft theft = new Theft();
        Assertions.assertEquals(9, theft.solution(new int[]{1, 2, 3, 1, 5}));
    }
}