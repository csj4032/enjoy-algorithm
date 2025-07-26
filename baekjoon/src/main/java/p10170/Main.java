/**
 * 백준 10170번: NFC West vs North
 * https://www.acmicpc.net/problem/10170
 * 
 * 문제 설명:
 * 주어진 형식대로 NFL 팀들의 승, 패, 무승부 기록을 출력하는 문제
 * 입력 없이 정해진 텍스트를 그대로 출력하면 됨
 * 
 * 핵심 개념:
 * - 기본 출력 (System.out.println 사용)
 * - 문자열 리터럴
 * - 텍스트 포맷팅과 정렬
 * - 단순 출력 문제
 * 
 * 시간복잡도: O(1) - 고정된 출력
 */
package p10170;

public class Main {

	public static void main(String[] args) {
		// NFC West 디비전 팀들의 기록 출력
		System.out.println("NFC West       W   L  T");
		System.out.println("-----------------------");
		System.out.println("Seattle        13  3  0");
		System.out.println("San Francisco  12  4  0");
		System.out.println("Arizona        10  6  0");
		System.out.println("St. Louis      7   9  0");
		System.out.println("");  // 빈 줄
		
		// NFC North 디비전 팀들의 기록 출력
		System.out.println("NFC North      W   L  T");
		System.out.println("-----------------------");
		System.out.println("Green Bay      8   7  1");
		System.out.println("Chicago        8   8  0");
		System.out.println("Detroit        7   9  0");
		System.out.println("Minnesota      5  10  1");
	}
}