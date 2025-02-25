package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimTest {

    @Test
    public void tset() {
        Prim prim = new Prim();
        Assertions.assertEquals(4, prim.minimumSpanningTree(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}