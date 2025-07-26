package p4153;

/*
 * 백준 4153번: 직각삼각형
 * https://www.acmicpc.net/problem/4153
 * 
 * [문제 분류] 기하학 (Geometry) / 수학 (Mathematics)
 * [난이도] Bronze 3
 * 
 * [문제 요약]
 * 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각삼각형인 것을 알았다.
 * 주어진 세변의 길이로 삼각형을 만들 때, 그 삼각형이 직각삼각형인지 아닌지를 판단하는 프로그램을 작성하시오.
 * 
 * [제약 조건]
 * - 각 변의 길이는 30,000 이하의 자연수
 * - 입력의 마지막은 0 0 0
 * - 세 변의 길이가 모두 0이면 입력 종료
 * 
 * [알고리즘 설명]
 * 1. 피타고라스 정리(Pythagorean Theorem) 적용
 * 2. 직각삼각형에서 빗변의 제곱 = 다른 두 변의 제곱의 합
 * 3. 세 변 중 어느 것이 빗변인지 모르므로 모든 경우를 확인
 * 
 * [구현 방법]
 * - 세 변을 a, b, c라 할 때, 다음 세 경우 중 하나가 성립하면 직각삼각형:
 *   1) a² + b² = c² (c가 빗변)
 *   2) a² + c² = b² (b가 빗변)  
 *   3) b² + c² = a² (a가 빗변)
 * - Math.pow()를 사용하여 제곱 계산
 * 
 * [수학적 배경: 피타고라스 정리]
 * - 직각삼각형에서 직각을 끼고 있는 두 변(각각 a, b)과 빗변(c) 사이의 관계
 * - 공식: a² + b² = c²
 * - 역도 성립: a² + b² = c²이면 직각삼각형
 * 
 * [유명한 피타고라스 삼조(Pythagorean Triple)]
 * - (3, 4, 5): 3² + 4² = 9 + 16 = 25 = 5²
 * - (5, 12, 13): 5² + 12² = 25 + 144 = 169 = 13²
 * - (8, 15, 17): 8² + 15² = 64 + 225 = 289 = 17²
 * 
 * [최적화 고려사항]
 * 1. Math.pow() 대신 직접 곱셈 사용 가능:
 *    int a2 = a * a; (정수 연산이 부동소수점 연산보다 빠름)
 * 
 * 2. 세 변을 정렬하여 가장 긴 변을 빗변으로 가정:
 *    Arrays.sort(sides);
 *    if (sides[0]*sides[0] + sides[1]*sides[1] == sides[2]*sides[2])
 * 
 * [부동소수점 정밀도 주의사항]
 * - Math.pow()는 double을 반환하므로 부동소수점 오차 가능
 * - 하지만 이 문제에서는 정수 제곱이므로 정확한 결과 보장
 * 
 * [시간복잡도] O(1) - 각 테스트케이스당 상수 시간
 * [공간복잡도] O(1) - 고정된 변수만 사용
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			// 입력 종료 조건
			if (a == 0 && b == 0 && c == 0) break;

			// 각 변의 제곱 계산
			double a2 = Math.pow(a, 2);
			double b2 = Math.pow(b, 2);
			double c2 = Math.pow(c, 2);

			// 피타고라스 정리 확인: 세 변 중 어느 것이 빗변인지 모르므로 모든 경우 확인
			if (a2 + b2 == c2 ||    // c가 빗변인 경우
				a2 + c2 == b2 ||    // b가 빗변인 경우
				b2 + c2 == a2) {    // a가 빗변인 경우
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
