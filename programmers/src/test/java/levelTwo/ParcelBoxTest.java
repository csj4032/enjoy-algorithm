package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParcelBoxTest {

    @Test
    public void test() {
        ParcelBox parcelBox = new ParcelBox();
        Assertions.assertEquals(2, parcelBox.solution(new int[]{4, 3, 1, 2, 5}));
        Assertions.assertEquals(5, parcelBox.solution(new int[]{5, 4, 3, 2, 1}));
        //Assertions.assertEquals(2, parcelBox.solution(new int[]{5, 2, 3, 4, 1}));
    }
}