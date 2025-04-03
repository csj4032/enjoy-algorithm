package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerfectCrimeTest {

    @Test
    public void test() {
        PerfectCrime perfectCrime = new PerfectCrime();
        Assertions.assertEquals(0, perfectCrime.solution(new int[][]{{1, 1}, {1, 1}}, 3, 3));
        Assertions.assertEquals(2, perfectCrime.solution(new int[][]{{1, 1}, {2, 3}, {2, 1}}, 4, 4));
        Assertions.assertEquals(0, perfectCrime.solution(new int[][]{{1, 1}, {2, 3}, {2, 1}}, 1, 7));
        Assertions.assertEquals(6, perfectCrime.solution(new int[][]{{3, 3}, {3, 3}}, 7, 1));
        Assertions.assertEquals(-1, perfectCrime.solution(new int[][]{{3, 3}, {3, 3}}, 6, 1));
        Assertions.assertEquals(2, perfectCrime.solution(new int[][]{{1, 1}, {1, 2}, {3, 3}}, 3, 4));
        Assertions.assertEquals(1, perfectCrime.solution(new int[][]{{3, 1}, {1, 2}, {1, 3}}, 3, 4));
        Assertions.assertEquals(3, perfectCrime.solution(new int[][]{{3, 3}, {2, 2}, {2, 2}}, 5, 5));
        Assertions.assertEquals(1, perfectCrime.solution(new int[][]{{2, 3}, {1, 2}, {2, 1}}, 5, 5));
        Assertions.assertEquals(1, perfectCrime.solution(new int[][]{{1, 3}, {1, 3}, {3, 1}}, 5, 5));
    }
}