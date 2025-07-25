package p11053;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 가장 긴 증가하는 부분 수열 (LIS)
 * 링크 : https://www.acmicpc.net/problem/11053
 * 분류 : 다이나믹 프로그래밍
 * 
 * 문제 해설:
 * - 수열에서 일부 원소를 골라서 만든 부분 수열 중 증가하는 수열의 최대 길이를 구하는 문제
 * - 예: [10, 9, 2, 5, 3, 7, 101, 18] → [2, 3, 7, 18] 또는 [2, 3, 7, 101] (길이 4)
 * 
 * DP 설계:
 * - d[i] = i번째 원소를 마지막으로 하는 증가하는 부분 수열의 최대 길이
 * - 점화식: d[i] = max(d[j] + 1) (j < i이고 a[j] < a[i]인 모든 j에 대해)
 * - 시간복잡도: O(N²)
 * 
 * 주의: 현재 코드에 로직 오류가 있어 수정이 필요함
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n + 1];  // 입력 수열 (1-indexed)
		int[] d = new int[n + 1];  // DP 배열: d[i] = i번째 원소를 마지막으로 하는 LIS 길이

		// 입력 받기
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		// DP 계산 (현재 코드는 로직 오류 있음 - 수정 필요)
		for (int i = 1; i <= n; i++) {
			d[i] = 1;  // 자기 자신만으로도 길이 1인 수열을 만들 수 있음
			for (int j = 1; j < i; j++) {  // j는 1부터 i-1까지
				if (a[j] < a[i] && d[i] < d[j] + 1) {  // a[j] < a[i]이고 더 긴 수열을 만들 수 있다면
					d[i] = d[j] + 1;  // 길이 갱신
				}
			}
		}

		// 전체 배열에서 최대값이 답
		System.out.println(Arrays.stream(d).max().orElse(0));
	}
}