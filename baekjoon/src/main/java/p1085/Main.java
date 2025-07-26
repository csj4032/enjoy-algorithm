package p1085;

/*
 * 백준 1085번: 직사각형에서 탈출
 * https://www.acmicpc.net/problem/1085
 * 
 * [문제 분류] 기하학 (Geometry) / 수학 (Mathematics)
 * [난이도] Bronze 3
 * 
 * [문제 요약]
 * 한수는 지금 (x, y)에 있다. 직사각형의 왼쪽 아래 꼭짓점은 (0, 0)이고, 
 * 오른쪽 위 꼭짓점은 (w, h)이다. 직사각형의 경계로 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 * 
 * [제약 조건]
 * - 1 ≤ x ≤ w-1
 * - 1 ≤ y ≤ h-1
 * - 1 ≤ w, h ≤ 1,000
 * 
 * [알고리즘 설명]
 * 1. 직사각형 내부의 한 점에서 경계까지의 최단거리 문제
 * 2. 직사각형의 경계는 4개의 변으로 구성: 왼쪽, 오른쪽, 아래쪽, 위쪽
 * 3. 각 변까지의 거리를 계산하여 최솟값을 구함
 * 
 * [구현 방법]
 * - 왼쪽 경계까지의 거리: x - 0 = x
 * - 아래쪽 경계까지의 거리: y - 0 = y  
 * - 오른쪽 경계까지의 거리: w - x
 * - 위쪽 경계까지의 거리: h - y
 * - 4개 거리 중 최솟값이 답
 * 
 * [기하학적 해석]
 * - 맨해튼 거리(Manhattan Distance) 개념 적용
 * - 직사각형 경계는 수평선 또는 수직선이므로 최단거리는 수직으로 이동
 * - 대각선 이동은 고려하지 않음 (문제에서 경계로의 거리를 요구)
 * 
 * [수학적 공식]
 * min_distance = min(x, y, w-x, h-y)
 * 
 * [시각적 이해]
 * (0,h) -------- (w,h)
 *   |              |
 *   |    (x,y)     |  ← 점 (x,y)에서 가장 가까운 경계 찾기
 *   |              |
 * (0,0) -------- (w,0)
 * 
 * [최적화]
 * - List 대신 Math.min() 체이닝 사용 가능:
 *   Math.min(Math.min(x, y), Math.min(w-x, h-y))
 * - 하지만 현재 구현이 가독성 면에서 더 좋음
 * 
 * [시간복잡도] O(1) - 상수 시간 계산
 * [공간복잡도] O(1) - 고정된 크기의 리스트 사용
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		// 4개 경계까지의 거리를 계산
		List<Integer> k = new ArrayList<>();
		k.add(x);        // 왼쪽 경계까지의 거리
		k.add(y);        // 아래쪽 경계까지의 거리
		k.add(w - x);    // 오른쪽 경계까지의 거리
		k.add(h - y);    // 위쪽 경계까지의 거리

		// 최솟값이 경계로 가는 최단거리
		System.out.println(k.stream().min(Integer::compare).get());
	}
}