/**
 * 백준 10174번: 팰린드롬
 * https://www.acmicpc.net/problem/10174
 * 
 * 문제 설명:
 * 여러 문자열이 주어졌을 때, 각 문자열이 팰린드롬인지 판별하는 문제
 * 팰린드롬: 앞에서 읽으나 뒤에서 읽으나 같은 문자열 (대소문자 무시)
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner, nextLine 사용)
 * - 배열을 이용한 여러 문자열 저장
 * - 문자열을 문자 배열로 변환 (toCharArray)
 * - 대소문자 변환 (toLowerCase)
 * - 양방향 비교 알고리즘
 * - 함수 분리와 재사용
 * 
 * 시간복잡도: O(n * m) - n개 문자열, 각 문자열 길이 m
 */
package p10174;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();    // 문자열 개수
		sc.nextLine();           // 개행문자 처리

		// n개의 문자열을 배열에 저장
		String[] m = new String[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextLine();
		}

		// 각 문자열이 팰린드롬인지 확인하여 결과 출력
		for (int i = 0; i < n; i++) {
			System.out.println(isPalindrome(m[i]) ? "Yes" : "No");
		}
	}

	// 주어진 문자열이 팰린드롬인지 확인하는 함수
	private static boolean isPalindrome(String str) {
		char[] c = str.toLowerCase().toCharArray();  // 소문자로 변환 후 문자 배열로
		
		// 문자열의 앞쪽과 뒤쪽을 비교 (절반만 비교하면 됨)
		for (int j = 0; j < c.length / 2; j++) {
			if (c[j] != c[c.length - j - 1]) {  // 대칭 위치 문자 비교
				return false;  // 다르면 팰린드롬이 아님
			}
		}
		return true;  // 모든 비교가 성공하면 팰린드롬
	}
}