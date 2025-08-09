package p17298;

import java.util.*;
import java.io.*;

/**
 * 제목 : 오큰수 - Next Greater Element using Stack
 * 링크 : https://www.acmicpc.net/problem/17298
 * 분류 : 자료구조, 스택
 * 난이도 : Gold IV
 * 
 * ========================================================================
 * ■ 문제 개요 및 핵심 개념
 * ========================================================================
 * 
 * 수열 A의 각 원소에 대해 "오큰수"를 찾는 문제입니다.
 * 오큰수는 해당 원소의 오른쪽에 있으면서 그보다 큰 수 중 가장 왼쪽에 있는 수입니다.
 * 
 * ★ 핵심 아이디어:
 * - 스택을 이용한 효율적인 탐색
 * - 각 원소에 대해 오른쪽에서 자신보다 큰 첫 번째 원소 찾기
 * - 단조 감소 스택(Monotonic Decreasing Stack) 활용
 * 
 * ★ 알고리즘:
 * 1) 스택에는 인덱스를 저장
 * 2) 현재 원소가 스택 top의 원소보다 크면, 스택에서 pop하며 결과 배열에 현재 원소 저장
 * 3) 현재 원소의 인덱스를 스택에 push
 * 4) 마지막에 스택에 남은 원소들은 오큰수가 없으므로 -1
 * 
 * 시간복잡도: O(N) - 각 원소는 최대 한 번씩 push/pop
 * 공간복잡도: O(N) - 스택과 결과 배열
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            // 현재 원소가 스택 top 위치의 원소보다 크면
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        
        // 스택에 남은 원소들은 오큰수가 없음
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]);
            if (i < N - 1) sb.append(" ");
        }
        
        System.out.println(sb.toString());
    }
}