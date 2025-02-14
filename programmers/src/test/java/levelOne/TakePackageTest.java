package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TakePackageTest {

    @Test
    public void test() {
        TakePackage takePackage = new TakePackage();
        //Assertions.assertEquals(3, takePackage.solution(22, 6, 8));
        //Assertions.assertEquals(4, takePackage.solution(13, 3, 6));
        Assertions.assertEquals(5, takePackage.solution(30, 5, 6));
    }
}