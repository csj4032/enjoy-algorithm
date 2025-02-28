package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PathfindingGameTest {

    @Test
    public void test() {
        PathfindingGame pathfindingGame = new PathfindingGame();
        Assertions.assertArrayEquals(new int[][]{{7, 4, 6, 9, 1, 8, 5, 2, 3}, {9, 6, 5, 8, 1, 4, 3, 2, 7}}, pathfindingGame.solution(new int[][]{
                {5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}
        }));
    }
}