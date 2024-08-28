package levit;

import java.util.*;

public class Problem1 {

    public static void main(String[] args) {
        int year = 2024;
        System.out.println(solution(year));
    }

    private static final String[] daysOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    private static final int[] daysInMonthLeapYear = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static  Map<Integer, Map<String, List<Integer>>> solution(int year) {
        Map<Integer, Map<String, List<Integer>>> calendar = new LinkedHashMap<>();

        for (int day = 1; day <= 31; day++) {
            Map<String, List<Integer>> daysOfWeekMap = new LinkedHashMap<>();
            for (String dayOfWeek : daysOfWeek) {
                daysOfWeekMap.put(dayOfWeek, new ArrayList<>());
            }
            calendar.put(day, daysOfWeekMap);
        }

        int startDayIndex = getStartDayIndex(year);

        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= daysInMonthLeapYear[month]; day++) {
                String dayOfWeek = daysOfWeek[startDayIndex];
                calendar.get(day).get(dayOfWeek).add(month);
                startDayIndex = (startDayIndex + 1) % 7;
            }
        }

        return calendar;
    }

    private static int getStartDayIndex(int year) {
        int startDay = 0;
        int daysPassed = 0;

        for (int y = 2023; y < year; y++) {
            if (isLeapYear(y)) {
                daysPassed += 366;
            } else {
                daysPassed += 365;
            }
        }

        return (startDay + daysPassed % 7) % 7;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
}
