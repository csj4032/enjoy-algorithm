package p1991;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 제목 : 트리 순회
 * 링크 : https://www.acmicpc.net/problem/1991
 * 분류 : 트리, 재귀, 트리 순회
 * 
 * === 문제 해설 ===
 * 이진 트리의 세 가지 순회 방법(전위, 중위, 후위)을 구현하는 문제입니다.
 * 주어진 트리 구조에서 각 순회 방법에 따른 방문 순서를 출력해야 합니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) 트리 순회의 정의:
 *    - 전위 순회(Preorder): 루트 → 왼쪽 서브트리 → 오른쪽 서브트리
 *    - 중위 순회(Inorder): 왼쪽 서브트리 → 루트 → 오른쪽 서브트리  
 *    - 후위 순회(Postorder): 왼쪽 서브트리 → 오른쪽 서브트리 → 루트
 * 
 * 2) 재귀적 구조:
 *    - 각 서브트리도 같은 규칙으로 순회
 *    - 베이스 케이스: 빈 노드(null 또는 '.')에서 종료
 *    - 분할 정복 방식의 자연스러운 적용
 * 
 * 3) 트리 순회의 특성:
 *    - 전위 순회: 트리 복사, 접두 표기법 계산에 사용
 *    - 중위 순회: 이진 탐색 트리에서 정렬된 순서 출력
 *    - 후위 순회: 트리 삭제, 후위 표기법 계산에 사용
 * 
 * === 알고리즘 설계 ===
 * 1) 노드 표현: HashMap을 사용한 인접 리스트 방식
 * 2) 재귀 함수로 각 순회 구현
 * 3) 빈 노드 처리: "." 문자로 null 노드 표현
 * 4) 루트 노드부터 시작하여 전체 트리 순회
 * 
 * === 구현 세부사항 ===
 * 1) 자료구조 선택:
 *    - HashMap<String, Node>: 빠른 노드 접근 (O(1))
 *    - Node 클래스: 왼쪽, 오른쪽 자식 저장
 * 
 * 2) 재귀 호출 패턴:
 *    - preOrder: 출력 → left → right
 *    - inOrder: left → 출력 → right  
 *    - postOrder: left → right → 출력
 * 
 * === 최적화 기법 ===
 * 1) 공간 복잡도 최적화:
 *    - 현재: O(N) 해시맵 + O(H) 재귀 스택
 *    - 대안: Morris 순회 알고리즘 O(1) 공간
 * 
 * 2) 시간 복잡도:
 *    - 각 노드를 정확히 한 번씩 방문: O(N)
 *    - 해시맵 접근: O(1) 평균
 * 
 * 3) 메모리 효율성:
 *    - 문자열 대신 정수 인덱스 사용 가능
 *    - 배열 기반 트리 표현 가능
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O(N) (N: 노드 개수)
 * - 공간복잡도: O(N + H) (N: 해시맵, H: 재귀 스택 깊이)
 * - 최악의 경우 (편향 트리): O(N) 스택 공간
 * - 최선의 경우 (균형 트리): O(log N) 스택 공간
 * 
 * === 대안 해결법 ===
 * 1) 반복적 구현 (스택 사용):
 *    - 명시적 스택으로 재귀를 대체
 *    - 스택 오버플로우 방지
 * 
 * 2) Morris 순회 알고리즘:
 *    - O(1) 공간으로 중위 순회 가능
 *    - 트리 구조를 임시로 변경하여 순회
 * 
 * 3) 레벨 순서 순회 (BFS):
 *    - 큐를 사용한 너비 우선 탐색
 *    - 레벨별 노드 처리
 * 
 * === 트리 순회의 응용 ===
 * 1) 수식 트리 계산:
 *    - 전위: 접두 표기법 생성
 *    - 후위: 후위 표기법 계산
 * 
 * 2) 파일 시스템 탐색:
 *    - 전위: 디렉토리 먼저 처리
 *    - 후위: 파일 먼저 삭제 후 디렉토리 삭제
 * 
 * 3) 컴파일러 구현:
 *    - 추상 구문 트리(AST) 순회
 *    - 코드 생성 및 최적화
 * 
 * === 확장 문제들 ===
 * 1) 순회 결과로 트리 복원
 * 2) 스레드 이진 트리 구현
 * 3) 균형 트리 판별
 * 4) 트리 직렬화/역직렬화
 */
public class Main {

    static Map<String, Node> nodes = new HashMap();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            String c = sc.next();
            nodes.put(a, new Node(b, c));
        }
        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }

    private static void preOrder(String node) {
        if (node.equals(".")) return;
        System.out.print(node);
        preOrder(nodes.get(node).left);
        preOrder(nodes.get(node).right);
    }

    private static void inOrder(String node) {
        if (node.equals(".")) return;
        inOrder(nodes.get(node).left);
        System.out.print(node);
        inOrder(nodes.get(node).right);
    }

    private static void postOrder(String node) {
        if (node.equals(".")) return;
        postOrder(nodes.get(node).left);
        postOrder(nodes.get(node).right);
        System.out.print(node);
    }
}

class Node {
    String left;
    String right;

    public Node(String left, String right) {
        this.left = left;
        this.right = right;
    }
}