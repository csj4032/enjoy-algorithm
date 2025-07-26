package p14888;

import java.util.Scanner;

/**
 * 제목 : 연산자 끼워넣기
 * 링크 : https://www.acmicpc.net/problem/14888
 * 분류 : 백트래킹, 브루트포스, 순열
 * 
 * === 문제 해설 ===
 * N개의 수와 N-1개의 연산자가 주어질 때, 연산자를 수 사이에 끼워 넣어서
 * 만들 수 있는 식의 결과 중 최댓값과 최솟값을 구하는 문제입니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) 순열과 조합론:
 *    - N-1개의 연산자 위치에 대한 순열 문제
 *    - 중복되는 연산자가 있을 경우 중복순열
 *    - 최대 (N-1)! 가지의 경우의 수 (중복 없을 때)
 * 
 * 2) 백트래킹 이론:
 *    - 해공간 트리(Solution Space Tree)에서의 깊이 우선 탐색
 *    - 유망성 검사를 통한 가지치기 (현재 문제에서는 미적용)
 *    - 상태 공간의 체계적 탐색
 * 
 * 3) 연산자 우선순위:
 *    - 문제에서는 왼쪽부터 차례대로 계산 (우선순위 무시)
 *    - 일반적인 수학 연산과 다른 규칙 적용
 *    - 나눗셈은 정수 나눗셈 (소수점 버림)
 * 
 * === 알고리즘 설계 ===
 * 1) 백트래킹 접근법:
 *    - 각 위치에서 사용 가능한 연산자 선택
 *    - 선택 후 재귀 호출로 다음 위치 탐색
 *    - 모든 위치를 채우면 결과 계산 및 최댓값/최솟값 갱신
 * 
 * 2) 상태 관리:
 *    - 현재 채운 연산자 개수 (depth)
 *    - 사용된 연산자 체크 배열
 *    - 현재까지의 최댓값/최솟값
 * 
 * === 구현 세부사항 ===
 * 1) 자료구조 선택:
 *    - int[] numbers: 주어진 수들
 *    - int[] op: 연산자들 (1:+, 2:-, 3:*, 4:/)
 *    - boolean[] v: 연산자 사용 여부 체크
 *    - int[] temp: 현재 선택된 연산자 순서
 * 
 * 2) 연산자 입력 처리:
 *    - 각 연산자 개수만큼 배열에 저장
 *    - 인덱스를 통한 순차적 접근
 * 
 * 3) 계산 과정:
 *    - 첫 번째 수를 초기값으로 설정
 *    - 연산자와 다음 수를 순차적으로 적용
 *    - 각 연산 후 결과를 다음 연산의 피연산자로 사용
 * 
 * === 최적화 기법 ===
 * 1) 가지치기 최적화:
 *    - 현재 계산값이 이미 최댓값보다 작으면 조기 종료
 *    - 음수/양수 판별을 통한 범위 추정
 * 
 * 2) 메모리 최적화:
 *    - 배열 복사 대신 인덱스 기반 백트래킹
 *    - 불필요한 객체 생성 방지
 * 
 * 3) 중복 제거:
 *    - 같은 연산자가 여러 개일 때 중복 계산 방지
 *    - 순열의 중복 패턴 인식
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O((N-1)!) (최악의 경우, 모든 연산자가 다를 때)
 *   - 실제로는 중복 연산자로 인해 더 적은 경우의 수
 *   - N ≤ 11이므로 최대 10! = 3,628,800 정도
 * 
 * - 공간복잡도: O(N) 
 *   - 배열들과 재귀 스택의 깊이
 *   - 백트래킹 스택: O(N-1)
 * 
 * === 대안 해결법 ===
 * 1) next_permutation 사용:
 *    - C++ STL의 next_permutation 함수 활용
 *    - Java에서는 직접 구현해야 함
 * 
 * 2) 비트마스킹:
 *    - 연산자 사용 상태를 비트로 표현
 *    - 작은 N에 대해서만 효과적
 * 
 * 3) 반복적 구현:
 *    - 스택을 사용한 명시적 백트래킹
 *    - 재귀 호출 오버헤드 제거
 * 
 * 4) 동적 계획법:
 *    - 상태 공간이 너무 복잡해 적용 어려움
 *    - 메모이제이션 효과 제한적
 * 
 * === 백트래킹 문제의 특징 ===
 * 1) 해공간의 체계적 탐색:
 *    - 모든 가능한 해를 빠짐없이 검사
 *    - 재귀적 구조로 자연스러운 구현
 * 
 * 2) 상태 복원의 중요성:
 *    - 선택 후 탐색이 끝나면 원래 상태로 복원
 *    - 다른 선택지 탐색을 위한 필수 과정
 * 
 * 3) 최적화의 여지:
 *    - 유망성 검사를 통한 가지치기
 *    - 상한/하한 추정을 통한 조기 종료
 * 
 * === 실제 응용 분야 ===
 * - 조합 최적화 문제
 * - 스케줄링 문제
 * - 자원 할당 문제
 * - 퍼즐 및 게임 해결
 * - 회로 설계 최적화
 */
public class Main {

	static int[] numbers = new int[11];
	static int[] op = new int[10];
	static boolean[] v = new boolean[10];
	static int n = Integer.MIN_VALUE;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int idx = 0;

		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				op[idx++] = i + 1;
			}
		}

		dfs(0, new int[n - 1]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int idx, int[] temp) {
		if (idx == n - 1) {
			int num = numbers[0];
			for (int i = 0; i < n - 1; i++) {
				if (temp[i] == 1) num = num + numbers[i + 1];
				if (temp[i] == 2) num = num - numbers[i + 1];
				if (temp[i] == 3) num = num * numbers[i + 1];
				if (temp[i] == 4) num = num / numbers[i + 1];
			}
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if (!v[i]) {
				v[i] = true;
				temp[idx] = op[i];
				dfs(idx + 1, temp);
				v[i] = false;
			}
		}
	}
}
