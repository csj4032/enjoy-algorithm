package p10812;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 제목: 바구니 순서 바꾸기
 * 링크: https://www.acmicpc.net/problem/10812
 * 분류: 배열, 구현
 * 
 * 핵심 아이디어:
 * - 배열의 특정 구간을 회전(rotation)시키는 문제
 * - begin부터 end까지 구간에서 mid를 기준으로 앞뒤 순서를 바꿈
 * 
 * 알고리즘 접근:
 * 1. [begin, mid-1]과 [mid, end] 두 부분으로 나눔
 * 2. 뒷부분을 앞으로, 앞부분을 뒤로 이동
 * 3. ArrayList의 subList()와 addAll()을 활용한 구현
 * 
 * 학습 개념:
 * - 배열 회전(Array Rotation) 알고리즘
 * - ArrayList의 동적 조작 메서드들
 * - 리스트 구간 처리와 삽입/삭제 연산
 */
public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();  // 바구니 개수
		var m = sc.nextInt();  // 연산 개수
		var l = new ArrayList<Integer>();
		
		// 바구니 초기화 (1번부터 N번까지)
		for (int i = 1; i <= n; i++) l.add(i);
		
		// M번의 순서 바꾸기 연산
		for (int i = 0; i < m; i++) {
			var begin = sc.nextInt();  // 구간 시작
			var end = sc.nextInt();    // 구간 끝
			var mid = sc.nextInt();    // 회전 기준점
			
			// mid부터 end까지의 요소들을 앞으로 이동
			// [begin...mid-1][mid...end] → [mid...end][begin...mid-1]
			var t = new ArrayList(l.subList(mid - 1, end));
			
			// 기존 요소들 제거 (뒤에서부터 제거해야 인덱스 꼬이지 않음)
			for (int j = 0; j < t.size(); j++) l.remove(t.get(j));
			
			// 새로운 위치에 삽입
			l.addAll(begin - 1, t);
		}
		
		// 결과 출력
		System.out.println(l.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}
}