package challenge.floatic;

import java.util.*;

public class Problem2 {

    public static void main(String[] args) {
        Problem2 problem1 = new Problem2();
        System.out.println(problem1.solution("aabbbc"));
        System.out.println(problem1.solution("hellllllo"));
        System.out.println(problem1.solution("wonderful"));
    }

    public String solution(String line) {
        List<String> alphabets = new ArrayList<>();
        StringBuilder currentGroup = new StringBuilder();
        char prevChar = line.charAt(0);
        currentGroup.append(prevChar);

        for (int i = 1; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar == prevChar) {
                currentGroup.append(currentChar);
            } else {
                alphabets.add(currentGroup.toString());
                currentGroup = new StringBuilder();
                currentGroup.append(currentChar);
            }
            prevChar = currentChar;
        }
        alphabets.add(currentGroup.toString());
        System.out.println("alphabets: " + alphabets);

        StringBuilder answer = new StringBuilder();
        for (String group : alphabets) {
            if (group.length() > 1) {
                answer.append(group.charAt(0)).append('*');
            } else {
                answer.append(group);
            }
        }

        return answer.toString();
    }
}
