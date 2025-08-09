package p1085;

import java.util.Scanner;

/**
 * 백준 1085번 - 직사각형에서 탈출
 * https://www.acmicpc.net/problem/1085
 * 
 * 난이도: Bronze III
 * 분류: 수학, 기하학
 * 
 * 프로그래밍 기초 개념:
 * 1. 좌표계와 거리 계산
 * 2. 최솟값 구하기 (Math.min 사용)
 * 3. 기하학적 사고 - 직사각형과 점의 관계
 * 4. 조건문을 사용한 경우 비교
 * 
 * 문제 이해:
 * - 직사각형 내부의 점 (x, y)에서 경계까지의 최단거리 구하기
 * - 직사각형: 왼쪽 아래 (0,0), 오른쪽 위 (w,h)
 * - 점은 직사각형 내부에 있음 (경계는 포함하지 않음)
 * 
 * 초보자를 위한 팁:
 * - 좌표평면에서 점과 선분 사이의 거리는 수직거리입니다
 * - 직사각형의 4개 변 중 가장 가까운 변까지의 거리를 구해야 합니다
 * - 그림을 그려서 이해해보세요!
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 현재 위치 (x, y)와 직사각형 크기 (w, h) 입력
        int x = sc.nextInt(); // 현재 x 좌표
        int y = sc.nextInt(); // 현재 y 좌표  
        int w = sc.nextInt(); // 직사각형의 너비
        int h = sc.nextInt(); // 직사각형의 높이
        
        // 4개의 경계까지의 거리를 각각 계산
        int leftDistance = x;       // 왼쪽 경계까지: x - 0 = x
        int rightDistance = w - x;  // 오른쪽 경계까지: w - x  
        int bottomDistance = y;     // 아래쪽 경계까지: y - 0 = y
        int topDistance = h - y;    // 위쪽 경계까지: h - y
        
        // 4개 거리 중 최솟값 구하기
        // Math.min을 연쇄적으로 사용하여 최솟값 계산
        int minDistance = Math.min(
            Math.min(leftDistance, rightDistance),    // 좌우 중 최솟값
            Math.min(bottomDistance, topDistance)     // 상하 중 최솟값
        );
        
        System.out.println(minDistance);
        
        sc.close();
    }
}

/*
 * 더 간단한 방법:
 * int minDistance = Math.min(Math.min(x, w-x), Math.min(y, h-y));
 * 
 * 혹은 한 줄로:
 * System.out.println(Math.min(Math.min(x, w-x), Math.min(y, h-y)));
 */

/*
 * 학습 가이드:
 * 
 * 1. 좌표계 이해하기
 *    - (0,0)이 왼쪽 아래 모서리
 *    - (w,h)가 오른쪽 위 모서리
 *    - x축은 오른쪽으로 갈수록 커짐
 *    - y축은 위로 갈수록 커짐
 * 
 * 2. 거리 계산 원리
 *    직사각형 내부의 점에서 각 경계까지의 거리:
 *    - 왼쪽 경계 (x=0): 점의 x좌표 만큼
 *    - 오른쪽 경계 (x=w): w에서 점의 x좌표를 뺀 값
 *    - 아래쪽 경계 (y=0): 점의 y좌표 만큼  
 *    - 위쪽 경계 (y=h): h에서 점의 y좌표를 뺀 값
 * 
 * 3. 시각적 이해
 *    (0,h) -------- (w,h)
 *      |              |
 *      |    *(x,y)    |  ← 이 점에서 가장 가까운 경계는?
 *      |              |
 *    (0,0) -------- (w,0)
 * 
 * 4. 예시로 이해하기
 *    - 직사각형: (0,0) ~ (6,4)
 *    - 점의 위치: (2,1)
 *    - 거리들: 왼쪽=2, 오른쪽=4, 아래=1, 위=3
 *    - 최솟값: 1 (아래쪽 경계가 가장 가까움)
 * 
 * 5. Math.min() 사용법
 *    - Math.min(a, b): 두 값 중 작은 값 반환
 *    - 세 개 이상의 값 중 최솟값을 구하려면 여러 번 사용
 *    - Math.min(Math.min(a, b), c) 형태로 중첩 가능
 * 
 * 6. 실습해보기
 *    - 여러 점의 위치에서 테스트해보세요
 *    - 직사각형의 중앙에 가까운 점은 어떨까요?
 *    - 모서리에 가까운 점은 어떨까요?
 * 
 * 7. 실생활 응용
 *    - 게임에서 캐릭터가 맵 경계에서 얼마나 떨어져 있는지
 *    - 건물 내에서 가장 가까운 출구 찾기
 *    - 안전지대에서 위험지대까지의 거리
 */