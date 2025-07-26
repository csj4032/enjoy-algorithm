/**
 * 백준 10171번: 고양이
 * https://www.acmicpc.net/problem/10171
 * 
 * 문제 설명:
 * 아스키 아트로 고양이 그림을 출력하는 문제
 * 특수문자와 이스케이프 문자 처리에 주의해야 함
 * 
 * 핵심 개념:
 * - 기본 출력 (System.out.println 사용)
 * - 이스케이프 문자 (\\ for \, \' for ')
 * - 아스키 아트 출력
 * - 문자열 리터럴에서 특수문자 사용
 * 
 * 시간복잡도: O(1) - 고정된 출력
 */
package p10171;

public class Main {

	public static void main(String[] args) {
		// 고양이 아스키 아트 출력
		// \는 \\로, '는 \'로 이스케이프 처리
		System.out.println("\\    /\\");      // 고양이 귀
		System.out.println(" )  ( ')");     // 고양이 얼굴
		System.out.println("(  /  )");      // 고양이 코
		System.out.println(" \\(__)|");     // 고양이 입
	}
}