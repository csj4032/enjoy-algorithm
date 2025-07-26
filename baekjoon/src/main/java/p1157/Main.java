package p1157;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 제목: 단어 공부
 * 링크: https://www.acmicpc.net/problem/1157
 * 분류: 문자열, 해시맵
 * 
 * 핵심 아이디어:
 * - 주어진 단어에서 가장 많이 사용된 알파벳을 찾는 문제
 * - 대소문자 구분 없이 처리하고, 최빈값이 여러 개면 "?" 출력
 * 
 * 알고리즘 접근:
 * 1. 입력 문자열을 대문자로 변환
 * 2. 각 문자의 빈도수를 계산 (Stream API 활용)
 * 3. 최고 빈도수를 가진 문자들을 찾음
 * 4. 최빈 문자가 여러 개면 "?", 하나면 그 문자 출력
 * 
 * 학습 개념:
 * - 빈도수 계산과 최빈값 찾기
 * - Stream API의 고급 사용법 (groupingBy, counting, mapping)
 * - TreeMap을 이용한 정렬과 descendingMap() 활용
 * - 함수형 프로그래밍 스타일의 데이터 처리
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map.Entry<Long, List<String>> firstEntry = Stream.of(sc.next().toUpperCase().split("")).collect(groupingBy(String::valueOf, counting()))
				.entrySet().stream().collect(groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toList())))
				.entrySet().stream().collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, TreeMap::new)).descendingMap().firstEntry();
		System.out.println(firstEntry.getValue().size() > 1 ? "?" : firstEntry.getValue().get(0));
	}
}