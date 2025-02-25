package dbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Permutations : Permutation(순열)은 주어진 요소들을 순서 있게 배열하는 모든 가능한 방법을 의미합니다.
 * 예를 들어, {A, B, C}라는 세 요소의 순열은 다음과 같이 3! = 6가지가 있습니다:
 * ABC
 * ACB
 * BAC
 * BCA
 * CAB
 * CBA
 * 즉, 순열에서는 요소들의 순서가 중요하며, 순서가 바뀌면 다른 순열로 간주됩니다.
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for (int num : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> oldPermutation = queue.poll();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, num);
                    System.out.println("oldPermutation: " + oldPermutation + " newPermutation: " + newPermutation + " num: " + num);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        queue.add(newPermutation);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permute(nums);
        for (List<Integer> permutation : permutations) System.out.println(permutation);
    }
}