package p2960;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 백준 2960번: 에라토스테네스의 체 (Silver 4)
 * https://www.acmicpc.net/problem/2960
 * 
 * == 문제 분류 ==
 * 수학, 정수론, 소수, 에라토스테네스의 체
 * 
 * == 알고리즘 이론 ==
 * 1. 에라토스테네스의 체 (Sieve of Eratosthenes)
 *    - 고대 그리스 수학자 에라토스테네스가 고안
 *    - 특정 범위의 모든 소수를 찾는 효율적인 알고리즘
 *    - 2부터 시작하여 배수들을 차례로 제거
 * 
 * 2. 소수 판별의 진화
 *    - 단순 시행착오: O(√n) per number
 *    - 에라토스테네스: O(n log log n) for range
 *    - 선형 체: O(n) for range
 * 
 * 3. 제거 순서의 중요성
 *    - 이 문제는 표준 체와 달리 제거 순서를 추적
 *    - k번째로 제거되는 수를 찾는 변형 문제
 *    - 실제 체 구현과는 다른 접근 필요
 * 
 * == 핵심 아이디어 ==
 * 1. 2부터 n까지 각 소수에 대해 배수 제거
 * 2. 제거되는 순서를 기록
 * 3. k번째로 제거되는 수 반환
 * 4. 이미 제거된 수는 다시 제거하지 않음
 * 
 * == 시간복잡도 ==
 * - 현재 구현: O(n²) (비효율적)
 * - 최적화된 구현: O(n log log n)
 * 
 * == 공간복잡도 ==
 * O(n) - 제거된 수들을 저장하는 리스트
 * 
 * == 구현 최적화 기법 ==
 * 1. boolean 배열로 제거 여부 추적
 * 2. 소수만 순차적으로 처리
 * 3. 이미 제거된 수의 배수는 건너뛰기
 * 4. √n까지만 확인해도 충분한 경우 있음
 * 
 * == 표준 에라토스테네스의 체 ==
 * ```java
 * boolean[] isPrime = new boolean[n+1];
 * Arrays.fill(isPrime, true);
 * isPrime[0] = isPrime[1] = false;
 * 
 * for (int i = 2; i * i <= n; i++) {
 *     if (isPrime[i]) {
 *         for (int j = i * i; j <= n; j += i) {
 *             isPrime[j] = false;
 *         }
 *     }
 * }
 * ```
 * 
 * == 실무 응용 ==
 * - 암호학에서 큰 소수 생성
 * - RSA 알고리즘의 기초
 * - 해시 함수 설계
 * - 수학적 최적화 문제
 * 
 * == 관련 심화 문제 ==
 * - 백준 1929: 소수 구하기 (표준 에라토스테네스)
 * - 백준 6588: 골드바흐의 추측
 * - 백준 1456: 거의 소수
 * - 백준 4948: 베르트랑 공준
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> list = new ArrayList<>();

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j % i == 0 && !list.contains(j)) {
					list.add(j);
				}
			}
		}

		System.out.println(list.get(k - 1));
	}
}
