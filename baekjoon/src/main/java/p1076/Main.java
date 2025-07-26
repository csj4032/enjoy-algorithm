/**
 * 백준 1076번: 저항
 * https://www.acmicpc.net/problem/1076
 * 
 * 문제 설명:
 * 전자 저항의 색깔 코드를 이용하여 저항 값을 계산하는 문제
 * 첫 번째, 두 번째 색깔은 숫자 값을, 세 번째 색깔은 곱하는 값을 나타냄
 * 예: red red red = 22 * 100 = 2200 옴
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - HashMap을 이용한 매핑
 * - 사용자 정의 클래스 (Resistance)
 * - static 초기화 블록
 * - 문자열 연결과 숫자 변환
 * - Long 자료형 (큰 수 처리)
 * 
 * 시간복잡도: O(1) - HashMap 조회와 단순 계산
 */
package p1076;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	// 색깔별 저항 정보를 저장하는 맵
	static Map<String, Resistance> map = new HashMap<>();

	// 저항 색깔 코드표 초기화
	static {
		map.put("black", new Resistance("black", "0", 1L));
		map.put("brown", new Resistance("brown", "1", 10L));
		map.put("red", new Resistance("red", "2", 100L));
		map.put("orange", new Resistance("orange", "3", 1000L));
		map.put("yellow", new Resistance("yellow", "4", 10000L));
		map.put("green", new Resistance("green", "5", 100000L));
		map.put("blue", new Resistance("blue", "6", 1000000L));
		map.put("violet", new Resistance("violet", "7", 10000000L));
		map.put("grey", new Resistance("grey", "8", 100000000L));
		map.put("white", new Resistance("white", "9", 1000000000L));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 첫 번째와 두 번째 색깔의 값을 연결하여 기본 값 생성
		String value = map.get(sc.next()).value + map.get(sc.next()).value;
		
		// 기본 값에 세 번째 색깔의 곱셈값을 곱하여 최종 저항 계산
		Long multiplication = Long.valueOf(value) * map.get(sc.next()).multiplication;
		
		System.out.println(multiplication);
	}
}

// 저항 정보를 담는 클래스
class Resistance {
	String color;         // 색깔 이름
	String value;         // 숫자 값 (0~9)
	Long multiplication;  // 곱셈 값 (10^n)

	public Resistance(String color, String value, Long multiplication) {
		this.color = color;
		this.value = value;
		this.multiplication = multiplication;
	}
}
