package levelOne;

import java.util.HashMap;
import java.util.Map;

public class RunningRace {

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIndex = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }

        for (String calling : callings) {
            int index = playerIndex.get(calling);
            if (index > 0) {
                String prev = players[index - 1];
                players[index - 1] = calling;
                players[index] = prev;
                playerIndex.put(calling, index - 1);
                playerIndex.put(prev, index);
            }
        }
        return players;
    }
}
