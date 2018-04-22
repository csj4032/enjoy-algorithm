package p15702;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	static Map<Integer, Integer> problems = new HashMap<>();
	static Student[] students;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		students = new Student[m];

		for (int i = 0; i < n; i++) {
			problems.put(i, sc.nextInt());
		}

		for (int i = 0; i < m; i++) {
			int number = sc.nextInt();
			int score = 0;
			for (int j = 0; j < n; j++) {
				if (sc.next().equals("O")) {
					score += problems.get(j);
				}
			}
			students[i] = new Student(number, score);
		}

		Arrays.sort(students, Comparator.comparing(Student::getNumber));

		Student max = students[0];

		for (int i = 1; i < m; i++) {
			Student student = students[i];
			if (max.getScore() < student.getScore()) max = student;
		}

		System.out.println(max);

		Map map = Arrays.stream(students).sorted(Comparator.comparing(Student::getScore)).collect(
				Collectors.groupingBy(
						e -> e.getScore(),
						Collectors.collectingAndThen(
								Collectors.mapping(Student::getNumber, Collectors.toList()), l -> {
									l.sort(Comparator.naturalOrder());
									return l;
								}
				)));

		System.out.println(map);
	}
}

class Student {
	private Integer number;
	private Integer score;

	public Student(Integer number, Integer score) {
		this.number = number;
		this.score = score;
	}

	public Integer getNumber() {
		return number;
	}

	public Integer getScore() {
		return score;
	}

	public String toString() {
		return number + " " + score;
	}
}
