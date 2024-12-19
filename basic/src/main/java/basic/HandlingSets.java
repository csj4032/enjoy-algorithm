package basic;

import java.util.*;

public class HandlingSets {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4, 1, 2, 3, 4})));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i && !list.contains(k)) {
                    list.add(k);
                }
            }
        }

        return new int[list.size()];
    }

    private static List<List<Integer>> groupList(List<Integer> list, int n) {
        List<List<Integer>> group = new ArrayList<>();
        int size = list.size();
        int remainder = size % n;
        int loop = list.size() / n;
        if (remainder != 0) loop++;
        for (int i = 0; i < loop; i++) {
            int s = i * n;
            int e = s + n;
            if (e > size) {
                e = size;
            }
            group.add(list.subList(s, e));
        }
        return group;
    }

    private static String reverseString(String str) {
        int len = str.length();
        String ret = "";
        for (int i = len - 1; i >= 0; i--) {
            ret += str.charAt(i);
        }
        return ret;
    }

    private static List<Integer> binary(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            int temp = n / 2;
            list.add(n % 2);
            n = temp;
        }
        Collections.reverse(list);
        return list;
    }

    public static int StringToInt(String str) {
        int i = 0, num = 0, sign = 1;
        char[] c = str.toCharArray();

        if (c[i] == '-') {
            i++;
            sign = -1;
        }

        while (i < c.length) {
            num *= 10;
            num += c[i] - '0';
            i++;
        }

        return num * sign;
    }

    public static boolean oddEven(int n) {
        return ((n & 1) == 0);
    }
}