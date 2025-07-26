/**
 * 백준 10175번: Dominant Species
 * https://www.acmicpc.net/problem/10175
 * 
 * 문제 설명:
 * 여러 종의 동물들이 서식지별로 관찰된 데이터가 주어질 때,
 * 각 서식지에서 가장 우세한(dominant) 종을 찾는 문제
 * B(Bobcat)=2점, C(Coyote)=1점, M(Mountain Lion)=4점, W(Wolf)=3점
 * 동점인 경우 "There is no dominant species" 출력
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 문자열 처리와 문자 배열 변환
 * - 가중치를 이용한 점수 계산
 * - 최댓값 찾기 (Math.max 활용)
 * - 동점 처리 로직
 * - StringBuilder를 이용한 효율적 문자열 구성
 * 
 * 시간복잡도: O(n * m) - n개 서식지, 각 서식지당 m개 문자
 */
package p10175;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();  // 서식지 개수
		var sb = new StringBuilder();
		
		// 각 서식지에 대해 처리
		for (int i = 0; i < n; i++) {
			String location = sc.next();     // 서식지 이름
			String species = sc.next();      // 관찰된 종들 (BCMW 조합)
			sb.append(location + ": " + dominant(species) + "\n");
		}
		
		System.out.println(sb.toString());
	}

	// 주어진 종 데이터에서 우세한 종을 찾는 함수
	private static String dominant(String data) {
		int b = 0, c = 0, m = 0, w = 0;  // 각 종의 점수
		char[] chars = data.toCharArray();
		
		// 각 문자에 따라 해당 종의 점수 누적
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'B') b += 2;      // Bobcat: 2점
			if (chars[i] == 'C') c += 1;      // Coyote: 1점
			if (chars[i] == 'M') m += 4;      // Mountain Lion: 4점
			if (chars[i] == 'W') w += 3;      // Wolf: 3점
		}

		// 최고 점수 찾기
		int maxScore = Math.max(Math.max(m, w), Math.max(b, c));
		int dominantCount = 0;  // 최고점을 받은 종의 개수
		String result = "";

		// 각 종이 최고점인지 확인
		if (maxScore == b) {
			dominantCount++;
			result = "The Bobcat is the dominant species";
		}

		if (maxScore == c) {
			dominantCount++;
			result = "The Coyote is the dominant species";
		}

		if (maxScore == m) {
			dominantCount++;
			result = "The Mountain Lion is the dominant species";
		}

		if (maxScore == w) {
			dominantCount++;
			result = "The Wolf is the dominant species";
		}

		// 동점인 경우 (2개 이상의 종이 최고점)
		if (dominantCount > 1) {
			result = "There is no dominant species";
		}

		return result;
	}
}
