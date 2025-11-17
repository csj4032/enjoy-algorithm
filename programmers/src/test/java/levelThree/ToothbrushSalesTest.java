package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ToothbrushSalesTest {

    @Test
    public void test() {
        ToothbrushSales toothbrushSales = new ToothbrushSales();
        Assertions.assertArrayEquals(new int[]{360, 958, 108, 0, 450, 18, 180, 1080}, toothbrushSales.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}));
    }
}