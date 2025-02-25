package levelFour;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64063">호텔 방 배정</a>
 * Category : Union-Find, Map
 */
public class HotelRoomAssignment {

    private Map<Long, Long> roomMap = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            long reqRoom = room_number[i];
            long assignedRoom = find(reqRoom);
            answer[i] = assignedRoom;
            roomMap.put(assignedRoom, assignedRoom + 1);
        }
        return answer;
    }

    private long find(long room) {
        if (!roomMap.containsKey(room)) return room;
        long available = find(roomMap.get(room));
        roomMap.put(room, available);
        return available;
    }
}
