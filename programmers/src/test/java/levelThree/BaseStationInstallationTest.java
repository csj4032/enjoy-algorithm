package levelThree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseStationInstallationTest {

    @Test
    public void test() {
        BaseStationInstallation baseStationInstallation = new BaseStationInstallation();
        assertEquals(3, baseStationInstallation.solution(11, new int[]{4, 11}, 1));
        assertEquals(3, baseStationInstallation.solution(16, new int[]{9}, 2));
        assertEquals(2, baseStationInstallation.solution(16, new int[]{1, 10}, 2));
        assertEquals(3, baseStationInstallation.solution(16, new int[]{10, 16}, 2));
        assertEquals(3, baseStationInstallation.solution(16, new int[]{16}, 2));
        assertEquals(2, baseStationInstallation.solution(16, new int[]{1, 16}, 2));
        assertEquals(2, baseStationInstallation.solution2(16, new int[]{1, 16}, 2));
    }
}