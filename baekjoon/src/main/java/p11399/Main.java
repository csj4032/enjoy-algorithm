package p11399;

/*
 * 백준 11399번: ATM
 * https://www.acmicpc.net/problem/11399
 * 
 * [문제 분류] 그리디 알고리즘 / 정렬
 * [난이도] Silver 4
 * 
 * [문제 요약]
 * 인하은행에는 ATM이 1대밖에 없다. 지금 이 ATM 앞에 N명의 사람들이 줄을 서있다.
 * 사람은 1번부터 N번까지 번호가 매겨져 있고, i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분이다.
 * 각 사람이 돈을 인출하는데 필요한 시간의 합을 최소로 하려고 한다.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 1,000
 * - 1 ≤ Pi ≤ 1,000
 * 
 * [알고리즘 설명 - 그리디 접근법]
 * 1. 핵심 아이디어: 시간이 적게 걸리는 사람부터 먼저 처리해야 총 대기시간이 최소가 됨
 * 2. 각 사람의 대기시간 = 자신 앞에 있는 모든 사람들의 처리시간 + 자신의 처리시간
 * 3. 오름차순 정렬 후 누적합 계산
 * 
 * [예시 분석]
 * 사람별 처리시간: [3, 1, 4, 3, 2]
 * 
 * 1) 정렬 전: 3, 1, 4, 3, 2
 *    총 시간 = 3 + (3+1) + (3+1+4) + (3+1+4+3) + (3+1+4+3+2) = 32
 * 
 * 2) 정렬 후: 1, 2, 3, 3, 4
 *    총 시간 = 1 + (1+2) + (1+2+3) + (1+2+3+3) + (1+2+3+3+4) = 32
 * 
 * [수학적 증명]
 * - 처리시간을 t1, t2, ..., tn이라 하고 t1 ≤ t2 ≤ ... ≤ tn이라 가정
 * - 총 대기시간 = Σ(i=1 to n) Σ(j=1 to i) tj
 * - 이를 다시 정리하면: Σ(j=1 to n) tj × (n-j+1)
 * - 작은 값에 큰 계수가 곱해지므로 오름차순 정렬이 최적
 * 
 * [구현 방법들]
 * 1. 현재 방법 (List + 이중 반복문):
 *    - 직관적이지만 비효율적
 *    - 시간복잡도: O(n²)
 * 
 * 2. 효율적인 방법 (누적합 활용):
 *    Arrays.sort(times);
 *    int total = 0, cumulative = 0;
 *    for (int time : times) {
 *        cumulative += time;
 *        total += cumulative;
 *    }
 *    - 시간복잡도: O(n log n)
 * 
 * 3. 스트림 활용:
 *    list.stream()
 *        .mapToInt(Integer::intValue)
 *        .sorted()
 *        .reduce(0, (sum, time) -> sum + cumulative)
 * 
 * [현재 코드 분석]
 * 장점:
 * - 문제의 정의를 그대로 구현하여 이해하기 쉬움
 * - 각 사람의 대기시간을 명확히 계산
 * 
 * 단점:
 * - O(n²) 시간복잡도로 비효율적
 * - 중복 계산이 많음 (이전 합을 재활용하지 않음)
 * 
 * [최적화된 구현]
 * int[] times = new int[n];
 * for (int i = 0; i < n; i++) {
 *     times[i] = sc.nextInt();
 * }
 * Arrays.sort(times);
 * 
 * int totalWaitTime = 0;
 * int cumulativeTime = 0;
 * for (int time : times) {
 *     cumulativeTime += time;
 *     totalWaitTime += cumulativeTime;
 * }
 * 
 * [그리디 알고리즘의 특징]
 * - 각 단계에서 지역적으로 최적인 선택
 * - 전체적으로도 최적해 보장 (이 문제의 경우)
 * - 정렬 + 탐욕적 선택의 전형적인 패턴
 * 
 * [코딩테스트 출제 패턴]
 * - 그리디 알고리즘 입문 문제
 * - 정렬과 누적합의 조합
 * - 최적화 문제의 기본 유형
 * 
 * [관련 문제들]
 * - 회의실 배정 (1931번)
 * - 동전 0 (11047번)
 * - 주유소 (13305번)
 * 
 * [시간복잡도] 
 * - 현재: O(n²) - 이중 반복문
 * - 최적화: O(n log n) - 정렬 시간
 * 
 * [공간복잡도] O(n) - 입력 데이터 저장
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		list.sort(Comparator.naturalOrder());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				sum = sum + list.get(j);
			}
		}

		System.out.println(sum);
	}
}