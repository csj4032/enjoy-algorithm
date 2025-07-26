package p1009;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 제목 : 분산처리
 * 링크 : https://www.acmicpc.net/problem/1009
 * 분류 : 수학, 정수론, 모듈러 지수법
 * 
 * 문제 해설:
 * - a^b를 10으로 나눈 나머지를 구하는 문제 (단, 나머지가 0이면 10 출력)
 * - 즉, a^b의 마지막 자리 수를 구하는 것과 같음
 * - a와 b가 매우 클 수 있어서 직접 계산하면 오버플로우 발생
 * 
 * 해결 방법:
 * - 모듈러 지수법(Modular Exponentiation) 사용
 * - BigInteger의 modPow 메서드 활용
 * - a^b mod 10 = (a mod 10)^b mod 10의 성질 이용
 * 
 * 수학적 원리:
 * - (a * b) mod m = ((a mod m) * (b mod m)) mod m
 * - 거듭제곱의 경우 이진 지수법으로 효율적 계산 가능
 * - 10개 컴퓨터 중 마지막 번호가 담당 → 1~10번 (0이면 10번)
 * 
 * 시간복잡도: O(log b)
 * 공간복잡도: O(log a + log b) - BigInteger 크기
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // 테스트 케이스 개수
        
        for (int i = 0; i < t; i++) {
            String a = sc.next();  // 밑 (base)
            String b = sc.next();  // 지수 (exponent)
            
            // BigInteger의 modPow 메서드를 이용한 모듈러 지수법
            // a^b mod 10 계산
            BigInteger base = new BigInteger(a);
            BigInteger exponent = new BigInteger(b);
            BigInteger modPow = base.modPow(exponent, BigInteger.TEN);
            
            // 나머지가 0이면 10번 컴퓨터, 아니면 나머지 번호 컴퓨터
            int result = modPow.intValue();
            System.out.println(result == 0 ? 10 : result);
        }
    }
}