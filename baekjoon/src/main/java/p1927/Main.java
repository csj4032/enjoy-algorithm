package p1927;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 제목 : 최소 힙
 * 링크 : https://www.acmicpc.net/problem/1927
 * 분류 : 자료구조, 힙, 우선순위 큐
 * 
 * 문제 해설:
 * - 최소 힙을 이용하여 다음 연산들을 지원하는 프로그램 작성
 *   1) 자연수 x 입력: 배열에 x 추가
 *   2) 0 입력: 배열에서 가장 작은 값을 출력하고 제거, 비어있으면 0 출력
 * 
 * 최소 힙 (Min Heap):
 * - 완전 이진 트리 기반의 자료구조
 * - 부모 노드가 자식 노드보다 항상 작거나 같은 값을 가짐
 * - 루트 노드에 항상 최솟값이 위치
 * - 삽입/삭제 시간복잡도: O(log n)
 * 
 * Java에서의 구현:
 * - PriorityQueue 클래스 사용 (기본적으로 최소 힙으로 동작)
 * - add(): 원소 삽입, poll(): 최솟값 제거 및 반환
 * - isEmpty(): 힙이 비어있는지 확인
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();  // 연산의 개수
        
        // 최소 힙 (우선순위 큐) 생성
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            Long l = sc.nextLong();
            
            if (l != 0) {
                // 자연수가 입력되면 힙에 추가
                priorityQueue.add(l);
            } else {
                // 0이 입력되면 최솟값 출력 및 제거
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");  // 힙이 비어있으면 0 출력
                } else {
                    sb.append(priorityQueue.poll()).append("\n");  // 최솟값 출력 및 제거
                }
            }
        }
        System.out.println(sb.toString());
    }
}
