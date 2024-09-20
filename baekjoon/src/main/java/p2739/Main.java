package p2739;


public class Main {
    public static void main(String[] args) {
        int[] trees = {20, 15, 10, 17}; // 나무의 높이
        int M = 7; // 목표로 하는 나무 길이
        System.out.println(maxHeight(trees, M));
    }

    // 매개변수 탐색으로 자를 수 있는 최소 높이를 찾는 함수
    public static int maxHeight(int[] trees, int M) {
        int left = 0;
        int right = 20; // 나무의 최대 높이 (예시에서는 20)
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    total += (tree - mid); // mid 높이로 잘랐을 때 남는 나무 길이 계산
                }
            }

            // 남은 나무 길이가 목표치 M 이상이면, 더 높은 값 탐색
            if (total >= M) {
                answer = mid; // 조건을 만족하는 높이 기록
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }
}