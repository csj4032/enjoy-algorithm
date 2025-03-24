package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BilliardsPracticeTest {

    @Test
    public void test() {
        BilliardsPractice billiardsPractice = new BilliardsPractice();
        assertArrayEquals(new int[]{52, 37, 116}, billiardsPractice.solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}}));
    }
}