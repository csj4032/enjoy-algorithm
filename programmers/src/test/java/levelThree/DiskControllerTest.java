package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskControllerTest {

    @Test
    void test() {
        DiskController diskController = new DiskController();
        Assertions.assertEquals(8, diskController.solution(new int[][]{{0, 3}, {1, 9}, {3, 5}}));
        Assertions.assertEquals(72, diskController.solution(new int[][]{{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}));
        Assertions.assertEquals(6, diskController.solution(new int[][]{{0, 5}, {2, 10}, {10000, 2}}));
        Assertions.assertEquals(4, diskController.solution(new int[][]{{0, 1}, {0, 2}, {1, 6}}));
    }
}