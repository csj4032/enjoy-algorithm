package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BestSetTest {

    @Test
    public void test() {
        BestSet bestSet = new BestSet();
        Assertions.assertArrayEquals(new int[]{4, 5}, bestSet.solution(2, 9));
        Assertions.assertArrayEquals(new int[]{-1}, bestSet.solution(2, 1));
        Assertions.assertArrayEquals(new int[]{4, 4}, bestSet.solution(2, 8));
        Assertions.assertArrayEquals(new int[]{6, 6, 7}, bestSet.solution(3, 19));
        Assertions.assertArrayEquals(new int[]{23, 24, 24, 24, 24}, bestSet.solution(5, 119));

        BestSetBruteForce bestSetBruteForce = new BestSetBruteForce();
        Assertions.assertArrayEquals(new int[]{6, 6, 7}, bestSetBruteForce.solution(3, 19));
        Assertions.assertArrayEquals(new int[]{300, 300, 300, 300}, bestSetBruteForce.solution(4, 1200));
    }
}