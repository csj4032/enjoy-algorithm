package levelOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetentionPeriodPersonalInformation {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int current = toDaysCount(today);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] type = terms[i].split(" ");
            map.put(type[0], Integer.valueOf(type[1]) * 28);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacie = privacies[i].split(" ");
            String date = privacie[0];
            String type = privacie[1];
            int limit = toDaysCount(date) + map.get(type);
            //System.out.println(current + " " + limit);
            if (current >= limit) {
                answer.add(i + 1);
            }
        }
        System.out.println(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int toDaysCount(String date) {
        String[] yearMonthDay = date.split("\\.");
        int year = Integer.parseInt(yearMonthDay[0]);
        int month = Integer.parseInt(yearMonthDay[1]);
        int day = Integer.parseInt(yearMonthDay[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
