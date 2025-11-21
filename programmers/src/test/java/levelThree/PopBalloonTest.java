package levelThree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PopBalloonTest {

    @Test
    public void test() {
        PopBalloon popBalloon = new PopBalloon();
        assertEquals(3, popBalloon.solution(new int[]{9, -1, -5}));
        assertEquals(6, popBalloon.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }
}