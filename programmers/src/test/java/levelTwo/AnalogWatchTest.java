package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnalogWatchTest {

    @Test
    public void testSolution() {
        AnalogWatch analogWatch = new AnalogWatch();
        assertEquals(2, analogWatch.solution(0, 5, 30, 0, 7, 0));
        assertEquals(1, analogWatch.solution(12, 0, 0, 12, 0, 30));
        assertEquals(0, analogWatch.solution(0, 6, 1, 0, 6, 6));
        assertEquals(2852, analogWatch.solution(0, 0, 0, 23, 59, 59));
    }
}