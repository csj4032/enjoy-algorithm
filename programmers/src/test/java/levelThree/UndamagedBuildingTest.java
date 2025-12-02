package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UndamagedBuildingTest {

    @Test
    void test() {
        UndamagedBuilding undamagedBuilding = new UndamagedBuilding();
        Assertions.assertEquals(10, undamagedBuilding.solution(
                new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}},
                new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
//        Assertions.assertEquals(6, undamagedBuilding.solution(
//                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
//                new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));
    }
}