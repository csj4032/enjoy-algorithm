package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TangerineTest {

    @Test
    public void test() {
        Tangerine tangerine = new Tangerine();
        Assertions.assertEquals(3, tangerine.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        Assertions.assertEquals(2, tangerine.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        Assertions.assertEquals(1, tangerine.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}