package levelThree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/77486">다단계 칫솔 판매</a>
 * Category : DFS
 */
public class ToothbrushSales {

    int[] profit;
    int[] parent;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        parent = new int[n];
        profit = new int[n];

        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(enroll[i], i);

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
        System.out.println(Arrays.toString(profit));
        return profit;
    }

    private void distribute(int index, int money) {
        if (index == -1 || money == 0) return;
        int commission = money / 10;
        int remain = money - commission;
        profit[index] += remain;
        if (commission < 1) return;
        distribute(parent[index], commission);
    }
}
