package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingJewelryTest {

    @Test
    public void test() {
        ShoppingJewelry shoppingJewelry = new ShoppingJewelry();
        Assertions.assertArrayEquals(new int[]{3, 7}, shoppingJewelry.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
        Assertions.assertArrayEquals(new int[]{1, 3}, shoppingJewelry.solution(new String[]{"AA", "AB", "AC", "AA", "AC"}));
        Assertions.assertArrayEquals(new int[]{1, 1}, shoppingJewelry.solution(new String[]{"XYZ", "XYZ", "XYZ"}));
        Assertions.assertArrayEquals(new int[]{1, 5}, shoppingJewelry.solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"}));
        Assertions.assertArrayEquals(new int[]{1, 4}, shoppingJewelry.solution(new String[]{"A", "B", "B", "C"}));
        Assertions.assertArrayEquals(new int[]{1, 1}, shoppingJewelry.solution(new String[]{"A"}));
        Assertions.assertArrayEquals(new int[]{1, 3}, shoppingJewelry.solution(new String[]{"A", "B", "C"}));
        Assertions.assertArrayEquals(new int[]{3, 6}, shoppingJewelry.solution(new String[]{"A", "B", "B", "A", "E", "F"}));
    }
}