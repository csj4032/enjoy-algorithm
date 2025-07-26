package p10866;

/**
 * 백준 10866번: 덱
 * https://www.acmicpc.net/problem/10866
 * 
 * 문제 분류: 자료구조, 덱
 * 난이도: Silver IV
 * 
 * 핵심 알고리즘:
 * - 덱 (Deque: Double-ended Queue) 자료구조
 * - 양방향 삽입/삭제가 가능한 자료구조
 * 
 * 문제 해결 접근법:
 * 1. Java 내장 Deque 인터페이스와 LinkedList 구현체 사용
 * 2. push_front, push_back, pop_front, pop_back 등 양방향 연산 구현
 * 3. 각 명령어에 따른 적절한 메서드 호출
 * 
 * 시간 복잡도: O(1) per operation
 * 공간 복잡도: O(N)
 * 
 * 핵심 개념:
 * - 덱의 양방향 특성 이해
 * - 스택과 큐의 기능을 모두 포함하는 자료구조
 * - 예외 상황 처리 (빈 덱에서의 pop 연산들)
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// LinkedList는 Deque 인터페이스를 구현하므로 양방향 연산이 모두 O(1)
		Deque<Integer> deque = new LinkedList<>();
		
		// 각 명령어 처리
		for (int i = 0; i < n; i++) {
			String command = sc.next();
			
			// push_front: 정수를 덱의 앞에 넣는다
			if (command.equals("push_front")) {
				int x = sc.nextInt();
				deque.push(x);  // addFirst()와 동일
			}
			// push_back: 정수를 덱의 뒤에 넣는다
			else if (command.equals("push_back")) {
				int x = sc.nextInt();
				deque.addLast(x);  // offer()와 동일
			}
			// pop_front: 덱의 가장 앞에 있는 수를 빼고 출력 (없으면 -1)
			else if (command.equals("pop_front")) {
				System.out.println(deque.isEmpty() ? -1 : deque.pop());  // removeFirst()와 동일
			}
			// pop_back: 덱의 가장 뒤에 있는 수를 빼고 출력 (없으면 -1)
			else if (command.equals("pop_back")) {
				System.out.println(deque.isEmpty() ? -1 : deque.pollLast());  // removeLast()와 동일
			}
			// size: 덱에 들어있는 정수의 개수를 출력
			else if (command.equals("size")) {
				System.out.println(deque.size());
			}
			// empty: 덱이 비어있으면 1, 아니면 0을 출력
			else if (command.equals("empty")) {
				System.out.println(deque.isEmpty() ? 1 : 0);
			}
			// front: 덱의 가장 앞에 있는 정수를 출력 (없으면 -1)
			else if (command.equals("front")) {
				System.out.println(deque.isEmpty() ? -1 : deque.getFirst());  // peekFirst()와 동일
			}
			// back: 덱의 가장 뒤에 있는 정수를 출력 (없으면 -1)
			else if (command.equals("back")) {
				System.out.println(deque.isEmpty() ? -1 : deque.getLast());   // peekLast()와 동일
			}
		}
	}
}

/*
 * 덱(Deque) 자료구조 상세 분석:
 * 
 * 1. 덱의 특징:
 *    - Double-ended Queue의 줄임말
 *    - 양쪽 끝에서 삽입과 삭제가 모두 가능
 *    - 스택 + 큐의 기능을 모두 제공
 * 
 * 2. 주요 연산들:
 *    Front 연산:
 *    - addFirst(e) / push(e): 앞쪽에 삽입
 *    - removeFirst() / pop(): 앞쪽에서 제거
 *    - getFirst() / peekFirst(): 앞쪽 원소 조회
 *    
 *    Back 연산:
 *    - addLast(e) / offer(e): 뒤쪽에 삽입
 *    - removeLast() / pollLast(): 뒤쪽에서 제거
 *    - getLast() / peekLast(): 뒤쪽 원소 조회
 * 
 * 3. Java에서의 Deque 구현체:
 *    - LinkedList: 일반적인 용도, 메모리 오버헤드 있음
 *    - ArrayDeque: 성능이 더 좋음, 권장사항
 *    - LinkedBlockingDeque: 스레드 안전
 * 
 * 4. 덱 활용 예시:
 *    - 슬라이딩 윈도우 최대/최소값 (백준 11003)
 *    - 팰린드롬 검사
 *    - 브라우저 히스토리 (앞으로/뒤로 가기)
 *    - Undo/Redo 기능
 * 
 * 5. 시간 복잡도:
 *    - 모든 기본 연산: O(1)
 *    - 중간 삽입/삭제: O(n)
 * 
 * 6. 다른 구현 방법:
 * 
 * ArrayDeque 사용 (더 효율적):
 * Deque<Integer> deque = new ArrayDeque<>();
 * 
 * 직접 구현 (더블 링크드 리스트):
 * class CustomDeque {
 *     private Node head, tail;
 *     private int size;
 *     
 *     void addFirst(int val) { ... }
 *     void addLast(int val) { ... }
 *     int removeFirst() { ... }
 *     int removeLast() { ... }
 * }
 * 
 * 7. 자료구조별 비교:
 *    - 스택: LIFO, 한쪽 끝에서만 연산
 *    - 큐: FIFO, 한쪽 끝에서 삽입, 다른 쪽에서 삭제
 *    - 덱: 양쪽 끝에서 삽입/삭제 가능
 * 
 * 8. 관련 문제:
 *    - 백준 10828: 스택 (Stack 자료구조)
 *    - 백준 10845: 큐 (Queue 자료구조)
 *    - 백준 5430: AC (덱 응용)
 *    - 백준 11003: 최솟값 찾기 (덱 + 슬라이딩 윈도우)
 * 
 * 9. 실제 사용 시 권장사항:
 *    - 성능이 중요한 경우: ArrayDeque 사용
 *    - 메모리 사용량이 중요한 경우: 배열 기반 직접 구현
 *    - 일반적인 경우: LinkedList 사용해도 무방
 */