package sort;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SelectSortTest {

    @Test
    @Order(1)
    public void testSortBasic() {
        SelectSort selectSort = new SelectSort();
        int[] input = {20, 6, 55, 74, 3, 45, 13, 87, 46, 30};
        int[] expected = {3, 6, 13, 20, 30, 45, 46, 55, 74, 87};
        selectSort.sort(input);
        assertArrayEquals(expected, input);
    }

//    @Test
//    @Order(2)
//    public void testSortEmpty() {
//        SelectSort selectSort = new SelectSort();
//        int[] input = {};
//        int[] expected = {};
//        selectSort.sort(input);
//        assertArrayEquals(expected, input);
//    }
//
//    @Test
//    @Order(3)
//    public void testSortAlreadySorted() {
//        SelectSort selectSort = new SelectSort();
//        int[] input = {1, 2, 3, 4, 5};
//        int[] expected = {1, 2, 3, 4, 5};
//        selectSort.sort(input);
//        assertArrayEquals(expected, input);
//    }
}