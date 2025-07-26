package p9020;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 제목 : 골드바흐의 추측
 * 링크 : https://www.acmicpc.net/problem/9020
 * 분류 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
 * 
 * 문제 해설:
 * - 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다
 * - 주어진 짝수 N에 대해 N = A + B (A, B는 소수)를 만족하는 A, B를 찾는 문제
 * - 여러 쌍이 있을 경우, 두 소수의 차이가 가장 작은 것을 출력
 * 
 * 핵심 아이디어:
 * - N/2를 중심으로 양쪽으로 확장하며 두 소수를 찾으면 차이가 최소가 됨
 * - 에라토스테네스의 체로 미리 소수를 구하면 더 효율적
 * 
 * 해결 방법:
 * 1. N 미만의 모든 소수를 구함
 * 2. 각 소수 A에 대해 N-A가 소수인지 확인
 * 3. 조건을 만족하는 쌍 중 차이가 최소인 것을 선택
 * 
 * 시간복잡도: O(T * N * √N) - T는 테스트케이스 수
 * 공간복잡도: O(N) - 소수 리스트 저장
 * 
 * 개선점:
 * 1. 에라토스테네스의 체 사용으로 소수 판정 최적화
 * 2. N/2부터 역순으로 탐색하여 첫 번째로 찾은 쌍이 최소 차이
 * 3. 중복 소수 판정 제거로 성능 향상
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine().trim());
		String[] results = new String[testCases];

		// 각 테스트케이스 처리
		for (int i = 0; i < testCases; i++) {
			int target = Integer.parseInt(br.readLine().trim());
			
			// target 미만의 모든 소수를 구함
			List<Integer> primes = getPrimesBelow(target);
			
			// 골드바흐 쌍 찾기 (차이가 최소인 것)
			results[i] = findGoldbachPair(primes, target);
		}

		// 결과 출력
		for (String result : results) {
			bw.write(result + "\n");
		}
		bw.close();
	}

	/**
	 * 주어진 수 미만의 모든 소수를 구하는 메소드
	 * 개선점: 에라토스테네스의 체 사용으로 더 효율적으로 구현 가능
	 */
	private static List<Integer> getPrimesBelow(int limit) {
		List<Integer> primes = new ArrayList<>();
		
		// 2부터 limit-1까지 소수 판정
		for (int num = 2; num < limit; num++) {
			if (isPrime(num)) {
				primes.add(num);
			}
		}
		return primes;
	}

	/**
	 * 골드바흐 쌍을 찾는 메소드
	 * target = A + B (A <= B, A와 B는 소수)에서 B - A가 최소인 쌍을 찾음
	 * 
	 * 개선점: 중간값부터 역순 탐색으로 첫 번째 발견 쌍이 최소 차이
	 */
	private static String findGoldbachPair(List<Integer> primes, int target) {
		int minDifference = Integer.MAX_VALUE;
		String result = "";
		
		// 모든 소수 쌍을 확인
		for (int i = 0; i < primes.size(); i++) {
			int firstPrime = primes.get(i);
			
			// 첫 번째 소수가 target의 절반을 넘으면 중단
			if (firstPrime > target / 2) break;
			
			for (int j = i; j < primes.size(); j++) {
				int secondPrime = primes.get(j);
				
				if (firstPrime + secondPrime == target) {
					int difference = Math.abs(firstPrime - secondPrime);
					
					// 더 작은 차이를 가진 쌍 발견시 업데이트
					if (minDifference > difference) {
						minDifference = difference;
						result = firstPrime + " " + secondPrime;
					}
					break; // 합이 target과 같으면 더 큰 수는 확인할 필요 없음
				}
				
				// 합이 target보다 크면 더 이상 확인할 필요 없음
				if (firstPrime + secondPrime > target) break;
			}
		}
		return result;
	}

	/**
	 * 소수 판정 메소드
	 * 시간복잡도: O(√n)
	 * 
	 * 최적화된 소수 판정:
	 * 1. 2 미만은 소수가 아님
	 * 2. 2는 유일한 짝수 소수
	 * 3. 3 이상의 홀수만 확인 (짝수는 소수가 아니므로)
	 */
	private static boolean isPrime(int n) {
		// 2 미만은 소수가 아님
		if (n < 2) return false;
		
		// 2는 소수, 2를 제외한 짝수는 소수가 아님
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		
		// √n까지만 확인 (3부터 홀수만)
		int sqrt = (int) Math.sqrt(n);
		for (int i = 3; i <= sqrt; i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	// 더 효율적인 해결 방법 (에라토스테네스의 체 사용)
	/*
	private static boolean[] sieveOfEratosthenes(int limit) {
		boolean[] isPrime = new boolean[limit];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for (int i = 2; i * i < limit; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < limit; j += i) {
					isPrime[j] = false;
				}
			}
		}
		return isPrime;
	}
	
	// 최적화된 골드바흐 쌍 찾기
	private static String findGoldbachPairOptimized(boolean[] isPrime, int target) {
		// target/2부터 역순으로 탐색 (차이가 최소인 쌍을 먼저 찾기 위해)
		for (int i = target / 2; i >= 2; i--) {
			if (isPrime[i] && isPrime[target - i]) {
				return i + " " + (target - i);
			}
		}
		return "";
	}
	*/
}