package levelThree;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/152995">인사고과</a>
 * Category : 탐욕법(Greedy)
 * Description : 동료 평가 점수를 내린 차순으로 하고 태도 점수를 올림 차순으로 했을 때 peerScore 점수가 MaxPeer보다 작다면 제외 대상이라는 의미
 * [Ranking{id=0, attitudeScore=3, peerScore=2, totalScore=5}, Ranking{id=2, attitudeScore=3, peerScore=3, totalScore=6}, Ranking{id=1, attitudeScore=3, peerScore=4, totalScore=7}] 생존
 * [Ranking{id=2, attitudeScore=3, peerScore=3, totalScore=6}, Ranking{id=1, attitudeScore=3, peerScore=4, totalScore=7}, Ranking{id=0, attitudeScore=2, peerScore=2, totalScore=5}] 탈락
 */
public class PerformanceEvaluation {

    public static class Ranking implements Comparable<Ranking> {
        public int id;
        public int attitudeScore;
        public int peerScore;
        public int totalScore;

        public Ranking(int id, int attitudeScore, int peerScore) {
            this.id = id;
            this.attitudeScore = attitudeScore;
            this.peerScore = peerScore;
            this.totalScore = attitudeScore + peerScore;
        }

        @Override
        public String toString() {
            return "Ranking{" + "id=" + id + ", attitudeScore=" + attitudeScore + ", peerScore=" + peerScore + ", totalScore=" + totalScore + '}';
        }

        @Override
        public int compareTo(Ranking o) {
            if (this.attitudeScore == o.attitudeScore) {
                return Integer.compare(this.peerScore, o.peerScore);
            }
            return Integer.compare(o.attitudeScore, this.attitudeScore);
        }
    }

    public int solution(int[][] scores) {
        int candidate0Total = scores[0][0] + scores[0][1];

        List<Ranking> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] + scores[i][1] >= candidate0Total) {
                list.add(new Ranking(i, scores[i][0], scores[i][1]));
            }
        }

        Collections.sort(list);
        System.out.println(list);

        int maxPeer = 0;
        int rank = 1;
        for (Ranking r : list) {
            if (r.peerScore < maxPeer) {
                if (r.id == 0) {
                    return -1;
                }
                continue;
            }
            maxPeer = r.peerScore;
            if (r.totalScore > candidate0Total) rank++;
        }
        return rank;
    }
}
