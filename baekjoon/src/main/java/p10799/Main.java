package p10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 제목 : 쇠막대기
 * 링크 : https://www.acmicpc.net/problem/10799
 * 분류 : 자료구조, 스택
 * 
 * 문제 해설:
 * - 쇠막대기들이 겹쳐서 놓여있고, 레이저로 잘라낸 후 총 몇 개의 조각이 나오는지 구하는 문제
 * - '('와 ')'로 이루어진 문자열에서:
 *   · "()" : 레이저 (쇠막대기를 자름)
 *   · "(...)" : 쇠막대기 (괄호가 쌍을 이룸)
 * 
 * 해결 원리:
 * - 레이저가 K개의 쇠막대기를 관통하면 K개의 새로운 조각이 생성됨
 * - 각 쇠막대기는 자신을 자르는 레이저 개수 + 1개의 조각으로 나뉨
 * - 스택을 사용하여 현재 겹쳐있는 쇠막대기의 개수를 추적
 * 
 * 알고리즘:
 * 1. '('를 만나면 스택에 push (새로운 쇠막대기 시작)
 * 2. ')'를 만나면:
 *    - 직전이 '('였다면: 레이저 → 현재 스택 크기만큼 조각 추가
 *    - 직전이 ')'였다면: 쇠막대기 끝 → 1개 조각 추가 (마지막 조각)
 * 
 * 시간복잡도: O(N) - N은 문자열 길이
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n = br.readLine().trim().split("");
        int m = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n.length; i++) {
            String s = n[i];
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("*");
                } else {
                    stack.push(")");
                }
            }
        }

        int[] c = new int[100000];
        Arrays.fill(c, 1);
        int d = 0;
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i).equals("(")) {
                d++;
            } else if (stack.get(i).equals(")")) {
                d--;
                m += c[d];
                c[d] = 1;
            } else if (stack.get(i).equals("*")) {
                for (int j = 0; j < d; j++) {
                    c[j] = c[j] + 1;
                }
            }
        }
        System.out.println(m);
    }
}