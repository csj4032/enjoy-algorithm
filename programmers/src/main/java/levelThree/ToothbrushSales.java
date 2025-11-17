package levelThree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77486">다단계 칫솔 판매</a>
 * Category : DFS
 */
public class ToothbrushSales {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = {};

        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(enroll[i], i);

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (!referral[i].equals("-")) {
                parent[i] = indexMap.get(referral[i]);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int count = amount[i];
            int money = count * 100;
            int index = indexMap.get(s);
            distribute(index, money);
        }

        return answer;
    }

    private void distribute(int index, int money) {

    }
}
