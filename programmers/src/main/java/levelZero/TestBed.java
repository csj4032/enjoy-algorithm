package levelZero;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestBed {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(Integer::compareTo);
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Comparator.reverseOrder());
        for (String tuple : operations) {
            String op = tuple.split(" ")[0];
            Integer num = Integer.valueOf(tuple.split(" ")[1]);
            if (op.equals("I")) {
                priorityQueue.add(num);
                priorityQueue1.add(num);
                priorityQueue2.add(num);
            }
            if (op.equals("D")) {
                if (num == 1) {
                    Integer a = priorityQueue2.poll();
                    priorityQueue1.remove(a);
                    priorityQueue.remove(a);
                }
                if (num == -1) {
                    Integer b = priorityQueue1.poll();
                    priorityQueue2.remove(b);
                    priorityQueue.remove(b);
                }
            }
        }
        int max = 0, min = 0;
        if (!priorityQueue.isEmpty()) max = priorityQueue2.poll();
        if (!priorityQueue.isEmpty()) min = priorityQueue1.poll();
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        TestBed testBed = new TestBed();
        int[] result = testBed.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        //int[] result = testBed.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
//Stanley1yelnatS
//Stanley1yelnatS