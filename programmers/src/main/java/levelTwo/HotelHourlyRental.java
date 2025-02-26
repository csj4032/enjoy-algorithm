package levelTwo;

import java.util.*;

public class HotelHourlyRental {

    class BookTime implements Comparable<BookTime> {
        public int start;
        public int end;

        public BookTime(String[] times) {
            this.start = Integer.parseInt(times[0].split(":")[0]) * 60 + Integer.parseInt(times[0].split(":")[1]);
            this.end = Integer.parseInt(times[1].split(":")[0]) * 60 + Integer.parseInt(times[1].split(":")[1]);
        }

        @Override
        public int compareTo(BookTime other) {
            return this.start - other.start;
        }

        @Override
        public String toString() {
            return "BookTime{" + "start=" + start + ", end=" + end + '}';
        }
    }

    public int solution(String[][] book_time) {
        Queue<BookTime> queue = new PriorityQueue<>();
        List<LinkedList<BookTime>> bookTimes = new LinkedList<>();
        for (String[] times : book_time) {
            queue.add(new BookTime(times));
            bookTimes.add(new LinkedList<>());
        }

        while (!queue.isEmpty()) {
            BookTime bookTime = queue.poll();
            for (LinkedList<BookTime> time : bookTimes) {
                if (time.isEmpty()) {
                    time.add(bookTime);
                    break;
                } else {
                    BookTime lastBookTime = time.getLast();
                    System.out.println("lastBookTime: " + lastBookTime.end + " bookTime: " + bookTime.start);
                    if (lastBookTime.end + 10 <= bookTime.start) {
                        time.add(bookTime);
                        break;
                    }
                }
            }
        }


        System.out.println(bookTimes.size());
        int answer = 0;
        return answer;
    }
}
