package levelFour;

import java.util.*;

/**
 * Link : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/64063">호텔 방 배정</a>
 * Category :
 */
public class HotelRoomAssignment {

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Long> search = new HashMap<>();
        for (long i = 1L; i <= k; i++) search.put(i, 0L);
        for (int i = 0; i < room_number.length; i++) {
            Long wantRoom = room_number[i];
            Long room = search.get(wantRoom);
            if (room < 1L) {
                answer[i] = room_number[i];
                search.put(wantRoom, 1L);
            } else {
                while (true) {
                    Long assignRoom = search.get(++wantRoom);
                    if (assignRoom < 1L) {
                        answer[i] = wantRoom;
                        search.put(wantRoom, 1L);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
