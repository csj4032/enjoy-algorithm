package p1427;

/*
 * 백준 1427번: 소트인사이드
 * https://www.acmicpc.net/problem/1427
 * 
 * [문제 분류] 정렬 / 문자열
 * [난이도] Silver 5
 * 
 * [문제 요약]
 * 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자릿수를 내림차순으로 정렬해보자.
 * 
 * [제약 조건]
 * - 1 ≤ N ≤ 1,000,000,000
 * - N은 자연수
 * 
 * [알고리즘 설명]
 * 1. 입력받은 수를 문자열로 처리
 * 2. 각 자릿수를 분리하여 배열로 변환
 * 3. 내림차순 정렬 (Collections.reverseOrder() 사용)
 * 4. 정렬된 자릿수들을 순서대로 출력
 * 
 * [핵심 개념 - 문자열과 정렬]
 * - String.split(""): 문자열을 한 글자씩 분리
 * - Arrays.sort(array, Collections.reverseOrder()): 내림차순 정렬
 * - Stream.forEach(): 각 원소에 대해 연산 수행
 * 
 * [구현 방법들]
 * 1. 현재 방법 (문자열 배열 + 정렬):
 *    String[] digits = input.split("");
 *    Arrays.sort(digits, Collections.reverseOrder());
 * 
 * 2. char 배열 활용:
 *    char[] chars = input.toCharArray();
 *    Arrays.sort(chars);
 *    // 역순으로 출력
 * 
 * 3. 계수 정렬 (Counting Sort):
 *    int[] count = new int[10]; // 0~9 자릿수 개수
 *    for (char c : input.toCharArray()) {
 *        count[c - '0']++;
 *    }
 *    // 9부터 0까지 내림차순으로 출력
 * 
 * 4. Collections + List:
 *    List<Character> list = new ArrayList<>();
 *    for (char c : input.toCharArray()) list.add(c);
 *    Collections.sort(list, Collections.reverseOrder());
 * 
 * [최적화된 계수 정렬 구현]
 * StringBuilder sb = new StringBuilder();
 * int[] digitCount = new int[10];
 * for (char c : input.toCharArray()) {
 *     digitCount[c - '0']++;
 * }
 * for (int i = 9; i >= 0; i--) {
 *     for (int j = 0; j < digitCount[i]; j++) {
 *         sb.append(i);
 *     }
 * }
 * 
 * [각 방법의 특징]
 * 1. 문자열 배열 방식 (현재):
 *    - 구현이 직관적이고 간단
 *    - String 객체 생성으로 메모리 사용량 증가
 *    - 시간복잡도: O(k log k), k는 자릿수
 * 
 * 2. char 배열 방식:
 *    - 메모리 효율적
 *    - 기본 타입 사용으로 성능 향상
 *    - 역순 출력 처리 필요
 * 
 * 3. 계수 정렬 방식:
 *    - 가장 효율적 (O(k), k는 자릿수)
 *    - 자릿수가 0~9로 제한되어 있어 최적
 *    - 구현이 약간 복잡하지만 성능 최고
 * 
 * [Stream API 활용]
 * - Stream.of(array).forEach(): 배열을 스트림으로 변환 후 처리
 * - 함수형 프로그래밍 스타일로 간결한 출력
 * - System.out::print 메서드 참조 사용 가능
 * 
 * [실제 코딩테스트에서의 활용]
 * - 자릿수 조작 문제의 기본 패턴
 * - 문자열과 숫자 변환 연습
 * - 정렬 알고리즘의 실제 응용 사례
 * 
 * [시간복잡도] O(k log k) - k는 자릿수 개수
 * [공간복잡도] O(k) - 문자열 배열 저장
 * 
 * [개선 가능한 부분]
 * - 계수 정렬 사용으로 O(k) 시간복잡도 달성 가능
 * - StringBuilder 사용으로 출력 성능 향상
 * - 불필요한 Stream 생성 최소화
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split("");
		Arrays.sort(str, Collections.reverseOrder());
		Stream.of(str).forEach(e -> System.out.print(e));
	}
}