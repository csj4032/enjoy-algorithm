package challenge.fortyTwoDot;

import java.util.*;

public class Problem3 {

    public String[] solution(String[][] friends, String user_id) {

        List<String> answer = new ArrayList<>();

        Map<String, Set<String>> friendMap = new HashMap<>();

        for (int i = 0; i < friends.length; i++) {
            String user1 = friends[i][0];
            String user2 = friends[i][1];

            if (!friendMap.containsKey(user1)) friendMap.put(user1, new HashSet());
            if (!friendMap.containsKey(user2)) friendMap.put(user2, new HashSet());

            friendMap.get(user1).add(user2);
            friendMap.get(user2).add(user1);
        }

        Set<String> userFriends = friendMap.getOrDefault(user_id, new HashSet<>());

        Map<String, Integer> friendCount = new HashMap<>();
//        for (Iterator<String> it = userFriends.iterator(); it.hasNext(); ) {
//            String friendTarget = it.next();
//            Set<String> mutualFriends = friendMap.getOrDefault(friendTarget, new HashSet<>());
//            for (Iterator<String> it2 = mutualFriends.iterator(); it2.hasNext(); ) {
//                String friend = it2.next();
//                if (!friend.equals(user_id) && !userFriends.contains(friend)) {
//                    if (!friendCount.containsKey(friend)) {
//                        friendCount.put(friend, 0);
//                    }
//                    friendCount.put(friend, friendCount.get(friend) + 1);
//                }
//            }
//        }

        for (Iterator<String> it = userFriends.iterator(); it.hasNext(); ) {
            String friendTarget = it.next();
            Set<String> mutualFriends = friendMap.getOrDefault(friendTarget, new HashSet<>());
            for (Iterator<String> it2 = mutualFriends.iterator(); it2.hasNext(); ) {
                String friend = it2.next();
                if (!friend.equals(user_id) && !userFriends.contains(friend)) {
                    if (!friendCount.containsKey(friend)) {
                        friendCount.put(friend, 0);
                    }
                    friendCount.put(friend, friendCount.get(friend) + 1);
                }
            }
        }

        int max = 0;
        for (String key : friendCount.keySet()) {
            max = Math.max(max, friendCount.get(key));
        }

        for (String key : friendCount.keySet()) {
            if (friendCount.get(key) == max) {
                answer.add(key);
            }
        }
        answer.sort(String::compareTo);
        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Problem3 problemOne = new Problem3();
        String[][] friends = {{"david", "frank"},
                {"demi", "david"},
                {"frank", "james"},
                {"demi", "james"},
                {"claire", "frank"}
        };
        String user_id = "david";
        System.out.println(Arrays.toString(problemOne.solution(friends, user_id)));
    }
}
