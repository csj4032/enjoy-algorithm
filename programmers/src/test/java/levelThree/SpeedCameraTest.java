package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpeedCameraTest {

    @Test
    public void test() {
        SpeedCamera speedCamera = new SpeedCamera();
        Assertions.assertEquals(2, speedCamera.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
}