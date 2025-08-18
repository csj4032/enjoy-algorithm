package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelDeliveryTest {

    @Test
    public void testSolution() {
        ParcelDelivery parcelDelivery = new ParcelDelivery();
        assertEquals(16, parcelDelivery.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        //assertEquals(30, parcelDelivery.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
    }
}