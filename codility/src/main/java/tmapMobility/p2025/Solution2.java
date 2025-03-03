package tmapMobility.p2025;

import java.util.*;

public class Solution2 {

    Map<Integer, Set<Integer>> map = new HashMap<>();

    public int solution(int N, String S) {
        // Implement your solution here
        String[] reserved = S.split(" ");
        for (String seet : reserved) {
            int length = seet.length();
            Integer seetChar = seet.charAt(length - 1) - 65;
            int row = Integer.parseInt(seet.substring(0, length - 1));
            System.out.println(seet + " " + seetChar + " " + row);
            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }
            map.get(row).add(seetChar);
        }

        int total = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            Set<Integer> resvered = map.get(i);
            if (resvered == null) {
                resvered = Collections.emptySet();
            }
            String[] seets = new String[10];
            Arrays.fill(seets, "*");

            for (int index : resvered) {
                seets[index] = "R";
            }
            System.out.println(map);
            boolean left = isActive(seets, 1, 4);
            boolean mid = isActive(seets, 3, 6);
            boolean right = isActive(seets, 5, 8);
            if (left) count++;
            if (mid) count++;
            if (right) count++;
            total += count;
        }
        return total;
    }

    private boolean isActive(String[] seets, int start, int end) {
        for (int i = start; i <= end; i++) {
            if ("R".equals(seets[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(22, "1A 3C 2B 20G 5A"));
    }
}
