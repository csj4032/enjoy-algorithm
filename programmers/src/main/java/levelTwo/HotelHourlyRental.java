package levelTwo;

import java.util.*;

/**
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/155651
 * Category : Priority Queue, Greedy, Sorting, Simulation
 */
public class HotelHourlyRental {

    class BookTime implements Comparable<BookTime> {
        public String start;
        public String end;
        public int startSeconds;
        public int endSeconds;

        public BookTime(String[] times) {
            this.start = times[0];
            this.end = times[1];
            this.startSeconds = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
            this.endSeconds = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
        }

        @Override
        public int compareTo(BookTime other) {
            return this.startSeconds - other.startSeconds;
        }

        @Override
        public String toString() {
            return "BookTime{" + "start='" + start + '\'' + ", end='" + end + '\'' + ", startSeconds=" + startSeconds + ", endSeconds=" + endSeconds + '}';
        }
    }

    public int solution(String[][] book_time) {
        BookTime[] bookings = new BookTime[book_time.length];
        for (int i = 0; i < book_time.length; i++) bookings[i] = new BookTime(book_time[i]);
        Arrays.sort(bookings);
        Queue<Integer> roomQueue = new PriorityQueue<>();
        for (BookTime booking : bookings) {
            if (!roomQueue.isEmpty() && roomQueue.peek() <= booking.startSeconds) roomQueue.poll();
            roomQueue.offer(booking.endSeconds + 10);
        }
        return roomQueue.size();
    }
}
