package floatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {

    public static void main(String[] args) {
        int[][] recruits = {{1, 50}, {1, 60}, {3, 70}, {0, 65}, {2, 50}, {1, 90}};
        int experience = 2;
        int score = 70;
        Problem3 problem3 = new Problem3();
        System.out.println(Arrays.toString(problem3.solution(recruits, experience, score)));
    }

    public int[] solution(int[][] recruits, int s1, int s2) {
        List<Employee> employees = new ArrayList<>();
        List<Standard> stands = new ArrayList<>();
        for (int[] recruit : recruits) {
            stands.add(new Standard(recruit[0], recruit[1]));
            employees.add(new Employee(recruit[0], recruit[1]));
        }

        for (Standard stand : stands) {
            for (Employee employee : employees) {
                employee.directionCheck(stand.experience, stand.score, s1, s2);
            }
            // employees 의 direction 갯수
            long expertCount = employees.stream().filter(e -> e.direction == Direction.EXPERT).count();
            long seniorCount = employees.stream().filter(e -> e.direction == Direction.SENIOR).count();
            long juniorCount = employees.stream().filter(e -> e.direction == Direction.JUNIOR).count();
            System.out.println("expertCount: " + expertCount + ",seniorCount: " + seniorCount + ", juniorCount: " + juniorCount);
            if (expertCount <= seniorCount && seniorCount <= juniorCount) {
                System.out.println(stand);
                break;
            }
        }

        int baseExperience = employees.stream().filter(e -> e.direction == Direction.SENIOR).map(e -> e.experience).sorted().findFirst().orElse(s1);
        int baseScore = employees.stream().filter(e -> e.direction == Direction.SENIOR).map(e -> e.score).sorted().findFirst().orElse(s2);
        return new int[]{baseExperience, baseScore};
    }
}

enum Direction {
    JUNIOR, EXPERT, SENIOR
}


class Standard {
    int experience;
    int score;

    Standard(int experience, int score) {
        this.experience = experience;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "experience=" + experience +
                ", score=" + score +
                '}';
    }
}

class Employee {
    int experience;
    int score;
    Direction direction;

    Employee(int experience, int score) {
        this.experience = experience;
        this.score = score;
        this.direction = Direction.JUNIOR;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "experience=" + experience +
                ", score=" + score +
                ", direction=" + direction +
                '}';
    }

    public void directionCheck(int i, int j, int s1, int s2) {
        if (this.experience + this.score >= (s1 + s2)) {
            this.direction = Direction.SENIOR;
        } else if ((this.experience + this.score) > (i + j) && (this.experience + this.score) < (s1 + s2)) {
            this.direction = Direction.EXPERT;
        } else {
            this.direction = Direction.JUNIOR;
        }
    }
}
