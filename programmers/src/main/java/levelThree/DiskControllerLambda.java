package levelThree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Link : <a href="https://programmers.co.kr/learn/courses/30/lessons/42627">디스크 컨트롤러</a>
 * Category : Heap
 */
public class DiskControllerLambda {

    public int solution(int[][] jobs) {
        PriorityQueue<Job> jobQueue = new PriorityQueue<>((a, b) -> a.request == b.request ? a.through - b.through : a.request - b.request);
        for (int[] job : jobs) jobQueue.add(new Job(job[0], job[1]));

        int currentTime = 0, totalWaitTime = 0;
        PriorityQueue<Job> readyQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.through));

        while (!jobQueue.isEmpty() || !readyQueue.isEmpty()) {
            while (!jobQueue.isEmpty() && jobQueue.peek().request <= currentTime) {
                readyQueue.add(jobQueue.poll());
            }

            if (readyQueue.isEmpty()) {
                currentTime = jobQueue.peek().request;
            } else {
                Job job = readyQueue.poll();
                currentTime += job.through;
                totalWaitTime += currentTime - job.request;
            }
        }

        return totalWaitTime / jobs.length;
    }

    static class Job {
        int request;
        int through;

        public Job(int request, int through) {
            this.request = request;
            this.through = through;
        }
    }
}
