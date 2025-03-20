package levelTwo;

import java.util.*;

/**
 * Link: https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * Category: Combination, Backtracking
 */
public class MineMinerals {

    public int solution(int[] picks, String[] minerals) {
        int answer = Integer.MAX_VALUE;
        List<List<String>> combinations = new ArrayList<>();
        generateCombinations(picks[0], picks[1], picks[2], new ArrayList<>(), combinations);
        for (List<String> combination : combinations) {
            Queue<String> pickList = new LinkedList<>();
            Queue<String> mineralList = new LinkedList<>();
            for (String mineral : minerals) mineralList.add(mineral);
            for (int i = 0; i < combination.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    pickList.add(combination.get(i));
                }
            }
            int fatigue = 0;
            while (!mineralList.isEmpty() && !pickList.isEmpty()) {
                String pick = pickList.poll();
                String mineral = mineralList.poll();
                if (pick.equals("diamond")) fatigue++;
                if (pick.equals("iron") && mineral.equals("diamond")) fatigue += 5;
                if (pick.equals("iron") && mineral.equals("iron")) fatigue++;
                if (pick.equals("iron") && mineral.equals("stone")) fatigue++;
                if (pick.equals("stone") && mineral.equals("diamond")) fatigue += 25;
                if (pick.equals("stone") && mineral.equals("iron")) fatigue += 5;
                if (pick.equals("stone") && mineral.equals("stone")) fatigue++;
            }
            answer = Math.min(answer, fatigue);
        }
        return answer;
    }

    private static void generateCombinations(int a, int b, int c, List<String> current, List<List<String>> result) {
        if (a == 0 && b == 0 && c == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (a > 0) {
            current.add("diamond");
            generateCombinations(a - 1, b, c, current, result);
            current.remove(current.size() - 1);
        }
        if (b > 0) {
            current.add("iron");
            generateCombinations(a, b - 1, c, current, result);
            current.remove(current.size() - 1);
        }
        if (c > 0) {
            current.add("stone");
            generateCombinations(a, b, c - 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
