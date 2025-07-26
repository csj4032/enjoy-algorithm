package p11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 11659번: 구간 합 구하기 4 (Silver 3)
 * https://www.acmicpc.net/problem/11659
 * 
 * == 문제 분류 ==
 * 누적 합, 전처리
 * 
 * == 알고리즘 이론 ==
 * 1. 누적 합 (Prefix Sum)
 *    - 배열의 첫 번째 원소부터 i번째 원소까지의 합
 *    - prefixSum[i] = arr[0] + arr[1] + ... + arr[i]
 *    - 구간 합 = prefixSum[r] - prefixSum[l-1]
 * 
 * 2. 구간 합 쿼리 최적화
 *    - 단순 반복문: O(n) × 쿼리 수
 *    - 누적 합: O(1) × 쿼리 수 (전처리 O(n))
 *    - 업데이트가 없는 경우 최적 솔루션
 * 
 * 3. 1차원 배열에서의 응용
 *    - 가장 기본적인 형태의 누적 합
 *    - 2차원, 3차원으로 확장 가능
 *    - 세그먼트 트리의 단순화된 버전
 * 
 * == 핵심 아이디어 ==
 * 1. 전처리: prefixSum[i] = prefixSum[i-1] + arr[i]
 * 2. 쿼리: sum(l, r) = prefixSum[r] - prefixSum[l-1]
 * 3. 0-based 인덱싱 주의 필요
 * 4. 범위 검사로 안전성 보장
 * 
 * == 시간복잡도 ==
 * - 전처리: O(n)
 * - 각 쿼리: O(1)
 * - 전체: O(n + m)
 * 
 * == 공간복잡도 ==
 * O(n) - 누적 합 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 0번 인덱스를 0으로 초기화하여 경계 처리 간소화
 * 2. BufferedReader로 입출력 최적화
 * 3. StringBuilder로 출력 최적화
 * 4. 원본 배열 없이 누적 합만 저장 가능
 * 
 * == 업데이트가 있는 경우 대안 ==
 * - 세그먼트 트리: O(log n) 업데이트/쿼리
 * - 펜윅 트리: O(log n) 업데이트/쿼리
 * - Square Root Decomposition: O(√n)
 * 
 * == 실무 응용 ==
 * - 시계열 데이터의 구간 합 계산
 * - 재무 데이터의 구간별 총합
 * - 센서 데이터의 누적 측정값
 * - 웹 분석에서 기간별 조회수 합계
 * 
 * == 관련 심화 문제 ==
 * - 백준 2042: 구간 합 구하기 (업데이트 포함)
 * - 백준 11660: 구간 합 구하기 5 (2차원)
 * - 백준 10986: 나머지 합 (모듈러 누적 합)
 * - 백준 2559: 수열 (슬라이딩 윈도우)
 */
public class Main {

	private static int[] m;
	private static int[] l;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		m = new int[n];
		l = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			m[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				l[i] = m[i];
			} else {
				l[i] = l[i - 1] + m[i];
			}
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(sectionSum(s - 1, e - 1));
			sb.append("\n");
		}
		System.out.println(sb);


	}

	private static int sectionSum(int s, int e) {
		return l[e] - (l[s] - m[s]);
	}
}
