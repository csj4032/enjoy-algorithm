package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DonutBarTest {

    @Test
    public void solution() {
        DonutBar donutBar = new DonutBar();
        //Assertions.assertArrayEquals(new int[]{2, 1, 1, 0}, donutBar.solution(new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}}));
        Assertions.assertArrayEquals(new int[]{4, 0, 1, 2}, donutBar.solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}}));
    }
}