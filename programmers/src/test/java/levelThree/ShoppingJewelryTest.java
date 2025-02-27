package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingJewelryTest {

    @Test
    public void test() {
        ShoppingJewelry shoppingJewelry = new ShoppingJewelry();
        Assertions.assertArrayEquals(new int[]{3, 7}, shoppingJewelry.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
    }
}