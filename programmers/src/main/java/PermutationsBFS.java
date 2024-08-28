import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PermutationsBFS {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for (int num : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> oldPermutation = queue.poll();
                // 현재 리스트에 새로운 숫자를 삽입할 수 있는 모든 위치에 삽입
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, num);
                    System.out.println("oldPermutation: " + oldPermutation + " newPermutation: " + newPermutation + " num: " + num);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation); // 완성된 순열을 결과 리스트에 추가
                    } else {
                        queue.add(newPermutation); // 아직 완성되지 않은 순열은 큐에 추가
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
