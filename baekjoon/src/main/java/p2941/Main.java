package p2941;

import java.util.*;

/**
 * 제목: 크로아티아 알파벳
 * 링크: https://www.acmicpc.net/problem/2941
 * 분류: 문자열, 정규표현식
 * 
 * 핵심 아이디어:
 * - 크로아티아 알파벳을 고려하여 문자열의 길이를 구하는 문제
 * - 크로아티아 알파벳: c=, c-, dz=, d-, lj, nj, s=, z= (8개)
 * - 이들 조합을 하나의 문자로 계산해야 함
 * 
 * 알고리즘 접근:
 * 1. 모든 크로아티아 알파벳 조합을 찾아서 하나의 문자로 치환
 * 2. 정규표현식을 사용하여 일괄 치환 (replaceAll)
 * 3. 치환된 문자열의 길이가 곧 크로아티아 알파벳을 고려한 문자 개수
 * 
 * 학습 개념:
 * - 정규표현식의 OR 연산자(|) 활용
 * - String.replaceAll() 메서드 사용법
 * - 문자열 패턴 매칭과 치환 기법
 * - 특수 문자 조합 처리 방법
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();  // 입력 문자열
		
		// 크로아티아 알파벳 조합을 모두 공백 하나로 치환
		// 정규표현식 "|"는 OR 연산자로 여러 패턴 중 하나와 매칭
		// c=, c-, dz=, d-, lj, nj, s=, z= 각각을 공백 하나로 치환
		System.out.println(str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", " ").length());
	}
}