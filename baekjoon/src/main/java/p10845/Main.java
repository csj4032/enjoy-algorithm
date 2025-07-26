package p10845;

/**
 * 백준 10845번: 큐
 * https://www.acmicpc.net/problem/10845
 * 
 * 문제 분류: 자료구조, 큐
 * 난이도: Silver IV
 * 
 * 핵심 알고리즘:
 * - 큐 (Queue) 자료구조 구현
 * - FIFO (First In First Out) 원리
 * 
 * 문제 해결 접근법:
 * 1. 더블 링크드 리스트 기반 큐 구현
 * 2. push, pop, size, empty, front, back 연산 구현
 * 3. 각 명령어에 따른 적절한 메서드 호출
 * 
 * 시간 복잡도: O(1) per operation
 * 공간 복잡도: O(N)
 * 
 * 핵심 개념:
 * - 큐의 기본 연산들 이해 (FIFO)
 * - 첫 번째(front)와 마지막(back) 포인터 관리
 * - 예외 상황 처리 (빈 큐에서의 pop, front, back)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue queue = new Queue();
		
		// 각 명령어 처리
		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");
			
			// push: 정수를 큐에 넣는다 (back에 추가)
			if (command[0].equals("push")) {
				queue.push(Integer.parseInt(command[1]));
			}
			// front: 큐의 가장 앞에 있는 정수를 출력 (없으면 -1)
			else if (command[0].equals("front")) {
				System.out.println(queue.front());
			}
			// back: 큐의 가장 뒤에 있는 정수를 출력 (없으면 -1)
			else if (command[0].equals("back")) {
				System.out.println(queue.back());
			}
			// size: 큐에 들어있는 정수의 개수를 출력
			else if (command[0].equals("size")) {
				System.out.println(queue.size());
			}
			// pop: 큐에서 가장 앞에 있는 정수를 빼고 출력 (없으면 -1)
			else if (command[0].equals("pop")) {
				System.out.println(queue.pop());
			}
			// empty: 큐가 비어있으면 1, 아니면 0을 출력
			else if (command[0].equals("empty")) {
				System.out.println(queue.isEmpty());
			}
		}
	}
}

/**
 * 더블 링크드 리스트 기반 큐 구현
 * FIFO (First In First Out) 원리를 따름
 */
class Queue {
	private int size;          // 큐에 저장된 원소의 개수
	private Node current;      // 큐의 가장 뒤(back) 노드 (최근에 추가된 노드)
	private Node first;        // 큐의 가장 앞(front) 노드 (가장 먼저 추가된 노드)

	/**
	 * 큐에 원소를 삽입 (enqueue)
	 * 큐의 뒤쪽(back)에 새 원소를 추가
	 * 시간 복잡도: O(1)
	 */
	public void push(int value) {
		if (isEmpty() == 1) {
			// 큐가 비어있는 경우: 첫 번째 노드 생성
			first = new Node(null, null, value);
			current = first;
		} else {
			// 큐에 원소가 있는 경우: 뒤쪽에 새 노드 추가
			Node newNode = new Node(current, null, value);
			current.setNext(newNode);  // 기존 마지막 노드의 next를 새 노드로 설정
			current = newNode;         // 새 노드를 current(back)로 설정
		}
		size++;
	}

	/**
	 * 큐에서 가장 앞의 원소를 제거하고 반환 (dequeue)
	 * 시간 복잡도: O(1)
	 */
	public int pop() {
		if (first == null) {
			return -1;  // 큐가 비어있으면 -1 반환
		}
		
		int value = first.getValue();
		first = first.getNext();  // front를 다음 노드로 이동
		
		if (first == null) {
			// 큐가 완전히 비워진 경우
			current = null;
		}
		
		size--;
		return value;
	}

	/**
	 * 큐에 저장된 원소의 개수 반환
	 * 시간 복잡도: O(1)
	 */
	public int size() {
		return size;
	}

	/**
	 * 큐가 비어있는지 확인
	 * 시간 복잡도: O(1)
	 * @return 비어있으면 1, 아니면 0
	 */
	public int isEmpty() {
		return size == 0 ? 1 : 0;
	}

	/**
	 * 큐의 가장 앞에 있는 원소 반환 (제거하지 않음)
	 * 시간 복잡도: O(1)
	 */
	public int front() {
		return first == null ? -1 : first.getValue();
	}

	/**
	 * 큐의 가장 뒤에 있는 원소 반환 (제거하지 않음)
	 * 시간 복잡도: O(1)
	 */
	public int back() {
		return current == null ? -1 : current.getValue();
	}
}

/**
 * 큐의 각 원소를 나타내는 노드 클래스
 * 더블 링크드 리스트 구조로 구현
 */
class Node {
	private Node prev;        // 이전 노드에 대한 참조
	private Node next;        // 다음 노드에 대한 참조
	private int value;        // 노드에 저장된 값

	public Node(Node prev, Node next, int value) {
		this.prev = prev;
		this.next = next;
		this.value = value;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}
}

/*
 * 큐 활용 예시:
 * 
 * 1. BFS (너비 우선 탐색) - 백준 2178, 7576
 * 2. 레벨 순회 (Level Order Traversal)
 * 3. 프로세스 스케줄링
 * 4. 캐시 구현 (FIFO 교체 정책)
 * 
 * 다른 구현 방법:
 * 
 * 1. 배열 기반 원형 큐:
 * int[] queue = new int[MAX_SIZE];
 * int front = 0, rear = 0;
 * 
 * 2. Java 내장 Queue 인터페이스:
 * Queue<Integer> queue = new LinkedList<>();
 * queue.offer(value);  // enqueue
 * queue.poll();        // dequeue
 * 
 * 3. ArrayDeque 사용 (성능상 더 좋음):
 * ArrayDeque<Integer> queue = new ArrayDeque<>();
 * 
 * 스택 vs 큐 비교:
 * - 스택: LIFO (Last In First Out) - 가장 최근 데이터부터 처리
 * - 큐: FIFO (First In First Out) - 가장 오래된 데이터부터 처리
 * 
 * 관련 문제:
 * - 백준 10828: 스택 (Stack 자료구조)
 * - 백준 10866: 덱 (Deque 자료구조)
 * - 백준 2164: 카드2 (큐 응용)
 * - 백준 1158: 요세푸스 문제 (큐 응용)
 */