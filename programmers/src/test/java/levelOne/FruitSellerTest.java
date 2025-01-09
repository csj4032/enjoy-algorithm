package levelOne;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FruitSellerTest {

    @Test
    public void test() {
        FruitSeller fruitSeller = new FruitSeller();
        Assertions.assertEquals(8, fruitSeller.solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        Assertions.assertEquals(33, fruitSeller.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }
}