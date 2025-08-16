package levelThree;

import java.util.*;

public class ShuttleBus {

    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) pq.offer(timeToMinutes(time));
        int lastBusTime = 0;
        List<Integer> lastBusCrew = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lastBusTime = 540 + (i * t);
            List<Integer> currentCrew = new ArrayList<>();
            for (int j = 0; j < m && !pq.isEmpty() && pq.peek() <= lastBusTime; j++) currentCrew.add(pq.poll());
            if (i == n - 1) lastBusCrew = currentCrew;
        }

        int arrivalTime;
        if (lastBusCrew.size() < m) {
            arrivalTime = lastBusTime;
        } else {
            arrivalTime = lastBusCrew.get(lastBusCrew.size() - 1) - 1;
        }

        return formatTime(arrivalTime);
    }

    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String formatTime(int minutes) {
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
    }
}
