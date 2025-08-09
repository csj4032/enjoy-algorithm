package p10430;

import java.util.Scanner;

/**
 * 백준 10430번 - 나머지
 * https://www.acmicpc.net/problem/10430
 * 
 * 난이도: Bronze V
 * 분류: 수학, 구현, 사칙연산
 * 
 * 프로그래밍 기초 개념:
 * 1. 나머지 연산의 성질 (모듈러 연산)
 * 2. 수학적 공식의 프로그래밍 구현
 * 3. 괄호를 이용한 연산 순서 제어
 * 
 * 수학 개념:
 * - (A+B)%C == ((A%C) + (B%C))%C
 * - (A×B)%C == ((A%C) × (B%C))%C
 * 이는 모듈러 연산의 분배법칙입니다!
 * 
 * 초보자를 위한 팁:
 * - 나머지 연산(%)은 큰 수의 계산에서 매우 유용합니다
 * - 암호학, 해시 함수 등에서 자주 사용됩니다
 * - 시계 계산도 나머지 연산의 좋은 예시입니다 (13시 = 1시)
 */
public class Main {
    public static void main(String[] args) {
        // Scanner로 입력받기
        Scanner sc = new Scanner(System.in);
        
        // 세 정수 A, B, C 입력받기
        int A = sc.nextInt(); // 첫 번째 수
        int B = sc.nextInt(); // 두 번째 수  
        int C = sc.nextInt(); // 나누는 수 (모듈러)
        
        // 첫 번째 공식: (A+B)%C
        // 먼저 A와 B를 더한 후, C로 나눈 나머지를 구합니다
        int result1 = (A + B) % C;
        System.out.println(result1);
        
        // 두 번째 공식: ((A%C) + (B%C))%C  
        // A를 C로 나눈 나머지와 B를 C로 나눈 나머지를 더한 후,
        // 다시 C로 나눈 나머지를 구합니다
        int result2 = ((A % C) + (B % C)) % C;
        System.out.println(result2);
        
        // 세 번째 공식: (A×B)%C
        // A와 B를 곱한 후, C로 나눈 나머지를 구합니다
        int result3 = (A * B) % C;
        System.out.println(result3);
        
        // 네 번째 공식: ((A%C) × (B%C))%C
        // A를 C로 나눈 나머지와 B를 C로 나눈 나머지를 곱한 후,
        // 다시 C로 나눈 나머지를 구합니다
        int result4 = ((A % C) * (B % C)) % C;
        System.out.println(result4);
        
        sc.close();
    }
}

/*
 * 학습 가이드:
 * 
 * 1. 모듈러 연산의 성질
 *    - 덧셈: (a + b) mod n = ((a mod n) + (b mod n)) mod n
 *    - 곱셈: (a × b) mod n = ((a mod n) × (b mod n)) mod n
 *    - 이 성질들은 큰 수 계산에서 오버플로우를 방지하는데 유용합니다
 * 
 * 2. 실생활 예시
 *    - 시계: 25시 = 25 % 12 = 1시
 *    - 요일: 오늘이 월요일이면 100일 후는? (1 + 100) % 7 = 4 (목요일)
 *    - 체크섬: 데이터 무결성 검사에 사용
 * 
 * 3. 프로그래밍에서의 활용
 *    - 해시 테이블의 인덱스 계산
 *    - 순환 큐의 인덱스 관리
 *    - 암호화 알고리즘
 * 
 * 4. 주의사항
 *    - 음수에 대한 나머지 연산은 언어마다 다를 수 있습니다
 *    - Java에서는 피제수의 부호를 따릅니다: -7 % 3 = -1
 * 
 * 5. 연산자 우선순위
 *    - %는 *, /와 같은 우선순위를 가집니다
 *    - 괄호를 사용하여 연산 순서를 명확히 하는 것이 좋습니다
 */