package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelHourlyRentalTest {

    @Test
    public void test() {
        HotelHourlyRental hotelHourlyRental = new HotelHourlyRental();
        assertEquals(3, hotelHourlyRental.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        // assertEquals(2, hotelHourlyRental.solution(new String[][]{{"10:00", "10:50"}, {"10:00", "10:50"}, {"12:00", "12:50"}}));
    }
}