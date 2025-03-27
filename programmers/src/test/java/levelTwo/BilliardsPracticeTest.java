package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BilliardsPracticeTest {

    @Test
    public void test() {
        BilliardsPractice billiardsPractice = new BilliardsPractice();
        assertArrayEquals(new int[]{52, 37, 116, 50}, billiardsPractice.solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}, {2, 2}}));
        assertArrayEquals(new int[]{164}, billiardsPractice.solution(10, 10, 1, 1, new int[][]{{9, 9}}));
        assertArrayEquals(new int[]{164}, billiardsPractice.solution(10, 10, 9, 9, new int[][]{{1, 1}}));
        assertArrayEquals(new int[]{164}, billiardsPractice.solution(10, 10, 9, 1, new int[][]{{1, 9}}));
        assertArrayEquals(new int[]{164}, billiardsPractice.solution(10, 10, 1, 9, new int[][]{{9, 1}}));
        assertArrayEquals(new int[]{10}, billiardsPractice.solution(3, 3, 1, 1, new int[][]{{2, 2}}));
        assertArrayEquals(new int[]{10}, billiardsPractice.solution(3, 3, 2, 2, new int[][]{{1, 1}}));
        assertArrayEquals(new int[]{45}, billiardsPractice.solution(10, 10, 3, 7, new int[][]{{3, 4}}));
        assertArrayEquals(new int[]{45}, billiardsPractice.solution(10, 10, 3, 7, new int[][]{{6, 7}}));
        assertArrayEquals(new int[]{45}, billiardsPractice.solution(10, 10, 3, 3, new int[][]{{3, 6}}));
        assertArrayEquals(new int[]{9}, billiardsPractice.solution(10, 10, 5, 9, new int[][]{{5, 8}}));
        assertArrayEquals(new int[]{9}, billiardsPractice.solution(10, 10, 5, 1, new int[][]{{5, 2}}));
        assertArrayEquals(new int[]{9}, billiardsPractice.solution(10, 10, 9, 5, new int[][]{{8, 5}}));
        assertArrayEquals(new int[]{9}, billiardsPractice.solution(10, 10, 1, 5, new int[][]{{2, 5}}));
    }
}