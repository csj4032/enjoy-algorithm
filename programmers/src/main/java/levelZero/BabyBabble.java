package levelZero;

import java.util.HashSet;

public class BabyBabble {

    public int solution(String[] babbling) {
        int answer = 0;
        String[] baby = {"aya", "ye", "woo", "ma"};
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        set.add(baby[i]);
                        if (i != j) set.add(baby[i] + baby[j]);
                        if (i != j & i != k & j != k) set.add(baby[i] + baby[j] + baby[k]);
                        if (i != j & i != k & j != k & i != l & j != k & j != l & k != l) set.add(baby[i] + baby[j] + baby[k] + baby[l]);
                    }
                }
            }
        }
        for (String babb : babbling) if (set.contains(babb)) answer++;
        return answer;
    }
}
