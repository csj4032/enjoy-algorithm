package challenge.floatic;

import java.util.*;

public class Problem1 {

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        //String[] logs1 = {"morgan string_compare", "felix string_compare", "morgan reverse", "rohan sort", "andy reverse", "morgan sqrt"};
        String[] logs2 = {"morgan sort", "felix sort", "morgan sqrt", "morgan sqrt", "rohan reverse", "rohan reverse"};
        //String[] logs3 = {"kate sqrt"};
        //System.out.println(Arrays.toString(problem1.solution(logs1)));
        System.out.println(Arrays.toString(problem1.solution(logs2)));
        //System.out.println(Arrays.toString(problem1.solution(logs3)));
    }

    public String[] solution(String[] logs) {
        Map<String, Set<String>> problemUserMap = new HashMap<>();
        Map<String, Set<String>> userProbleMap = new HashMap<>();

        // 유저별로 푼 문제를 저장, 문제별로 푼 유저를 저장
        for (String log : logs) {
            String[] parts = log.split(" ");
            String user = parts[0];
            String problem = parts[1];

            userProbleMap.putIfAbsent(user, new HashSet<>());
            userProbleMap.get(user).add(problem);

            problemUserMap.putIfAbsent(problem, new HashSet<>());
            problemUserMap.get(problem).add(user);
        }

        System.out.println(userProbleMap);
        System.out.println(problemUserMap);


        // 한문제 이상 푼 유저 수
        int problemSolvedUserCount = 0;
        int half = 0;
        for (Map.Entry<String, Set<String>> entry : userProbleMap.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                problemSolvedUserCount++;
            }
        }
        if (problemSolvedUserCount % 2 != 0) {
            half = problemSolvedUserCount / 2 + 1;
        } else {
            half = problemSolvedUserCount / 2;
        }

        System.out.println(problemSolvedUserCount);
        System.out.println(half);
        List<Map.Entry<String, Set<String>>> problemList = new ArrayList<>(problemUserMap.entrySet());

        // 문제를 푼 유저 수가 half 이상인 문제
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : problemList) {
            System.out.println("문제 이름: " + entry.getKey() + ", 푼 유저 수: " + entry.getValue().size());
            if (half <= entry.getValue().size()) {
                answer.add(entry.getKey());
            }
        }

        answer.sort(String::compareTo);
        return answer.toArray(new String[0]);
    }
}
