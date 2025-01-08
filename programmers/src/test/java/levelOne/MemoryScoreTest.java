package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryScoreTest {

    @Test
    public void test() {
        MemoryScore memoryScore = new MemoryScore();
        Assertions.assertArrayEquals(new int[]{19, 15, 6}, memoryScore.solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}));
    }
}
