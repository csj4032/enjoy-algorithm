package p10828;

/**
 * 백준 10828번: 스택
 * https://www.acmicpc.net/problem/10828
 * 
 * 문제 분류: 자료구조, 스택
 * 난이도: Silver IV
 * 
 * 핵심 알고리즘:
 * - 스택 (Stack) 자료구조 구현
 * - LIFO (Last In First Out) 원리
 * 
 * 문제 해결 접근법:
 * 1. 링크드 리스트 기반 스택 구현
 * 2. push, pop, size, empty, top 연산 구현
 * 3. 각 명령어에 따른 적절한 메서드 호출
 * 
 * 시간 복잡도: O(1) per operation
 * 공간 복잡도: O(N)
 * 
 * 핵심 개념:
 * - 스택의 기본 연산들 이해
 * - 링크드 리스트를 활용한 동적 크기 조절
 * - 예외 상황 처리 (빈 스택에서의 pop, top)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        
        // 각 명령어 처리
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            
            // push: 정수를 스택에 넣는다
            if (command[0].equals("push")) {
                stack.push(Integer.parseInt(command[1]));
            }
            // pop: 스택에서 가장 위에 있는 정수를 빼고 출력 (없으면 -1)
            else if (command[0].equals("pop")) {
                System.out.println(stack.pop());
            }
            // size: 스택에 들어있는 정수의 개수를 출력
            else if (command[0].equals("size")) {
                System.out.println(stack.size());
            }
            // empty: 스택이 비어있으면 1, 아니면 0을 출력
            else if (command[0].equals("empty")) {
                System.out.println(stack.isEmpty());
            }
            // top: 스택 가장 위에 있는 정수를 출력 (없으면 -1)
            else if (command[0].equals("top")) {
                System.out.println(stack.top());
            }
        }
    }
}

/**
 * 링크드 리스트 기반 스택 구현
 * LIFO (Last In First Out) 원리를 따름
 */
class Stack {

    private int size;         // 스택에 저장된 원소의 개수
    private Node current;     // 스택의 가장 위쪽 노드 (top)

    /**
     * 스택에 원소를 삽입
     * 시간 복잡도: O(1)
     */
    public void push(int value) {
        if (isEmpty() == 1) {
            // 스택이 비어있는 경우: 첫 번째 노드 생성
            current = new Node(value);
        } else {
            // 스택에 원소가 있는 경우: 새 노드를 맨 위에 추가
            Node newNode = new Node(value);
            newNode.setPrevNode(current);  // 이전 top을 새 노드의 prev로 설정
            current = newNode;             // 새 노드를 current(top)로 설정
        }
        size++;
    }

    /**
     * 스택에서 가장 위의 원소를 제거하고 반환
     * 시간 복잡도: O(1)
     */
    public int pop() {
        if (current == null) {
            return -1;  // 스택이 비어있으면 -1 반환
        } else {
            int value = current.getValue();
            current = current.getPrevNode();  // top을 이전 노드로 변경
            size--;
            return value;
        }
    }

    /**
     * 스택에 저장된 원소의 개수 반환
     * 시간 복잡도: O(1)
     */
    public int size() {
        return size;
    }

    /**
     * 스택이 비어있는지 확인
     * 시간 복잡도: O(1)
     * @return 비어있으면 1, 아니면 0
     */
    public int isEmpty() {
        return size == 0 ? 1 : 0;
    }

    /**
     * 스택의 가장 위에 있는 원소 반환 (제거하지 않음)
     * 시간 복잡도: O(1)
     */
    public int top() {
        if (current == null) {
            return -1;  // 스택이 비어있으면 -1 반환
        } else {
            return current.getValue();
        }
    }
}

/**
 * 스택의 각 원소를 나타내는 노드 클래스
 * 단일 연결 리스트 구조로 구현
 */
class Node {
    private Node prevNode;    // 이전 노드에 대한 참조 (스택에서 아래쪽)
    private final int value;  // 노드에 저장된 값

    public Node(int value) {
        this.value = value;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node node) {
        prevNode = node;
    }

    public int getValue() {
        return value;
    }
}

/*
 * 스택 활용 예시:
 * 
 * 1. 괄호 검사 (백준 9012)
 * 2. 후위 표기식 계산 (백준 1935)
 * 3. 히스토그램에서 가장 큰 직사각형 (백준 6549)
 * 4. 탑 (백준 2493)
 * 
 * 다른 구현 방법:
 * 
 * 1. ArrayList 사용:
 * List<Integer> stack = new ArrayList<>();
 * stack.add(value);        // push
 * stack.remove(stack.size()-1);  // pop
 * 
 * 2. Java 내장 Stack 클래스:
 * Stack<Integer> stack = new Stack<>();
 * stack.push(value);
 * stack.pop();
 * 
 * 관련 문제:
 * - 백준 10845: 큐 (Queue 자료구조)
 * - 백준 10866: 덱 (Deque 자료구조)
 * - 백준 4949: 균형잡힌 세상 (스택 응용)
 */