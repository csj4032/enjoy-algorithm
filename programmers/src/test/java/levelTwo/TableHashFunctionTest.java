package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableHashFunctionTest {

    @Test
    public void test() {
        TableHashFunction tableHashFunction = new TableHashFunction();
        Assertions.assertEquals(4, tableHashFunction.solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }
}