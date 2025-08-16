package levelThree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShuttleBusTest {

    @Test
    public void testSolution() {
        ShuttleBus shuttleBus = new ShuttleBus();
        assertEquals("09:00", shuttleBus.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        assertEquals("09:09", shuttleBus.solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        assertEquals("08:59", shuttleBus.solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        assertEquals("00:00", shuttleBus.solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        assertEquals("09:00", shuttleBus.solution(1, 1, 1, new String[]{"23:59"}));
        assertEquals("18:00", shuttleBus.solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }
}