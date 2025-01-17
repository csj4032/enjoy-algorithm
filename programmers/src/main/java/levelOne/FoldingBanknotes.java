package levelOne;

public class FoldingBanknotes {

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int a = bill[0];
        int b = bill[1];
        while (true) {
            if (a <= wallet[0] && b <= wallet[1]) break;
            if (a <= wallet[1] && b <= wallet[0]) break;
            if (a > b) {
                a = a / 2;
            } else {
                b = b / 2;
            }
            answer++;
        }
        return answer;
    }
}
