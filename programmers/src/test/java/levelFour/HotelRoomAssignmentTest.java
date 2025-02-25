package levelFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HotelRoomAssignmentTest {

    @Test
    public void test() {
        HotelRoomAssignment hotelRoomAssignment = new HotelRoomAssignment();
        Assertions.assertArrayEquals(new long[]{1, 3, 4, 2, 5, 6}, hotelRoomAssignment.solution(10L, new long[]{1, 3, 4, 1, 3, 1}));
        Assertions.assertArrayEquals(new long[]{1L, 3L, 4L, 2L, 1000000000000L, 5L}, hotelRoomAssignment.solution(10000000000001L, new long[]{1L, 3L, 4L, 1L, 1000000000000L, 3L}));
    }
}