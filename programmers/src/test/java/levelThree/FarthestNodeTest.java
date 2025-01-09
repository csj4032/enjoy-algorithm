package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FarthestNodeTest {

    @Test
    public void test() {
        FarthestNode farthestNode = new FarthestNode();
        Assertions.assertEquals(3, farthestNode.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
        Assertions.assertEquals(1, farthestNode.solution(4, new int[][]{{1, 3}, {2, 3}, {1, 2}, {2, 4}}));
        Assertions.assertEquals(2, farthestNode.solution(6, new int[][]{{1, 3}, {1, 2}, {3, 4}, {2, 4}, {4, 5}, {4, 6}}));
        Assertions.assertEquals(1, farthestNode.solution(6, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 1}, {4, 6}}));
    }
}