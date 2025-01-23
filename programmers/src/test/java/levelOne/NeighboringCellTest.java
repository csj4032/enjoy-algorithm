package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NeighboringCellTest {

    @Test
    public void test() {
        NeighboringCell neighboringCell = new NeighboringCell();
        Assertions.assertEquals(2, neighboringCell.solution(new String[][]{
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}}, 1, 1));
        Assertions.assertEquals(1, neighboringCell.solution(new String[][]{
                {"yellow", "green", "blue"},
                {"blue", "green", "yellow"},
                {"yellow", "blue", "blue"}}, 0, 1));
    }
}