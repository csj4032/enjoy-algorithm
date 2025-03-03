package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RicochetRobotsTest {

    @Test
    public void test() {
        RicochetRobots ricochetRobots = new RicochetRobots();
        Assertions.assertEquals(7, ricochetRobots.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
}