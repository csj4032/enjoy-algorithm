package levelTwo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollisionDetectorTest {

    @Test
    public void testCollisionDetector() {
        CollisionDetector collisionDetector = new CollisionDetector();
        //Assertions.assertEquals(1, collisionDetector.solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {2, 4}}));
        Assertions.assertEquals(9, collisionDetector.solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {4, 2}, {4, 3}}));
    }
}