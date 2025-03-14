package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterceptionSystemTest {

    @Test
    public void solution() {
        InterceptionSystem interceptionSystem = new InterceptionSystem();
        assertEquals(1, interceptionSystem.solution(new int[][]{{1, 4}}));
        assertEquals(2, interceptionSystem.solution(new int[][]{{1, 4}, {4, 6}}));
        assertEquals(3, interceptionSystem.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}}));
    }
}