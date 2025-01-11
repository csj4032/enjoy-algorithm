package levelZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TriangleInequalityTheoremTest {

    @Test
    public void test() {
        TriangleInequalityTheorem triangleInequalityTheorem = new TriangleInequalityTheorem();
        Assertions.assertEquals(1, triangleInequalityTheorem.solution(new int[]{1, 2}));
        Assertions.assertEquals(5, triangleInequalityTheorem.solution(new int[]{3, 6}));
        Assertions.assertEquals(13, triangleInequalityTheorem.solution(new int[]{11, 7}));
    }
}