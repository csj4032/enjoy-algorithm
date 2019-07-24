import java.util.Arrays;

//permutation
public class Question43 {

    public static void main(String[] args) {
        solve(new String[]{"A", "B", "C"});
    }

    private static void solve(String[] str) {
        recursive(str, 0, str.length, str.length);
    }

    private static void recursive(String[] str, int d, int n, int k) {
        if (d == k){
            System.out.println(Arrays.toString(str));
            return;
        }
        for (int i = d; i < n; i++) {
            swap(str, i, d);
            recursive(str, d+1, n, k);
            swap(str, i, d);
        }
    }

    private static void swap(String[] str, int i, int d) {
        String p = str[i];
        String q = str[d];
        str[i] = q;
        str[d] = p;
    }
}
