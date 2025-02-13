package levelOne;

import java.util.HashMap;
import java.util.Map;

public class Bandage {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = bandage[0];
        int recovery = bandage[1];
        int bonus = bandage[2];
        int currentHealth = health;
        int len = attacks.length;
        int count = 0;
        Map<Integer, Integer> attackMap = new HashMap<>();
        for (int[] attack : attacks) attackMap.put(attack[0], attack[1]);
        for (int i = 0; i <= attacks[len - 1][0]; i++) {
            if (attackMap.containsKey(i)) {
                currentHealth -= attackMap.get(i);
                count = 0;
            } else {
                count++;
                if (count == time) {
                    currentHealth += bonus + recovery;
                    count = 0;
                } else {
                    currentHealth += recovery;
                }
            }
            if (currentHealth > health) currentHealth = health;
            if (currentHealth <= 0) return -1;
        }
        return currentHealth;
    }
}
