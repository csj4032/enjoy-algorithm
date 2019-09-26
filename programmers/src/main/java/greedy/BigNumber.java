package greedy;

public class BigNumber {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int l = number.length();
        int r = l - k;
        Integer[] numbers = new Integer[l];
        for (int i = 0; i < l; i++) numbers[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        int p = 0;
        int q = l - r;
        for (int i = 0; i <= k; i++) {
            int m = -1;
            for (int j = p; j <= q; j++) {
                int a = numbers[j];
                if (m < a) m = a;
            }
            sb.append(m);
            p = number.indexOf(String.valueOf(m), p) + 1;
            r--;
            q = l - r;
            if (p == q) break;
        }
        sb.append(number.substring(q));
        return sb.toString();
    }
}