package p10804;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 제목: 카드 역배치
 * 링크: https://www.acmicpc.net/problem/10804
 * 분류: 배열, 구현
 * 
 * 핵심 아이디어:
 * - 1부터 20까지 배열된 카드에서 주어진 구간을 뒤집는 문제
 * - 10번의 뒤집기 연산을 순차적으로 수행
 * 
 * 알고리즘 접근:
 * 1. 초기 배열 [1, 2, 3, ..., 20] 생성
 * 2. 각 연산마다 start-end 구간의 카드를 역순으로 배치
 * 3. Collections.reverse() 또는 직접 구현으로 뒤집기 수행
 * 
 * 학습 개념:
 * - 배열 구간 뒤집기 (Reverse Array Segment)
 * - List의 subList() 활용
 * - Collections 유틸리티 클래스 사용법
 */
public class Main {

	private static List<Integer> cards = new ArrayList<>();

	static {
		for (int i = 1; i <= 20; i++) {
			cards.add(i);
		}
	}

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		// 10번의 뒤집기 연산 수행
		for (int i = 0; i < 10; i++) {
			var start = sc.nextInt();  // 시작 위치 (1-based)
			var end = sc.nextInt();    // 끝 위치 (1-based)
			reverse(start, end);       // 구간 뒤집기
		}
		// 최종 카드 배열 출력
		System.out.println(cards.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}

	/**
	 * 카드 배열의 start부터 end까지 구간을 뒤집는 메서드
	 * @param start 시작 위치 (1-based index)
	 * @param end 끝 위치 (1-based index)
	 */
	private static void reverse(int start, int end) {
		// subList로 구간을 추출하고 Collections.reverse()로 뒤집기
		List<Integer> temp = cards.subList(start - 1, end);
		Collections.reverse(temp);
		// 뒤집힌 결과를 원래 배열에 반영
		for (int i = start - 1; i < end; i++) {
			cards.set(i, temp.get(i - (start - 1)));
		}
	}
}
