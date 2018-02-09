package p10825;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		list.stream().sorted((e1, e2) -> {
					int result = e2.getKor().compareTo(e1.getKor());
					if (result == 0) {
						result = e1.getEng().compareTo(e2.getEng());
					}
					if (result == 0) {
						result = e2.getMat().compareTo(e1.getMat());
					}
					if (result == 0) {
						result = e1.getName().compareTo(e2.getName());
					}
					return result;
				}
		).forEach(e -> System.out.println(e.getName()));
	}
}

class Student {
	public String name;
	public Integer kor;
	public Integer eng;
	public Integer mat;

	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public Integer getKor() {
		return kor;
	}

	public Integer getEng() {
		return eng;
	}

	public Integer getMat() {
		return mat;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", kor=" + kor +
				", eng=" + eng +
				", mat=" + mat +
				'}';
	}
}