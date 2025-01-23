package levelOne;

public class VideoPlayer {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = convertToInt(video_len);
        int position = convertToInt(pos);
        int start = convertToInt(op_start);
        int end = convertToInt(op_end);
        int current = position;
        for (int i = 0; i < commands.length; i++) {
            if (start <= current && current <= end) current = end;
            if (commands[i].equals("prev")) {
                current = current - 10;
                if (current < 0) current = 0;
            } else {
                current = current + 10;
                if (current > videoLen) current = videoLen;
            }
            if (start <= current && current <= end) current = end;
        }
        return convertToString(current);
    }

    private String convertToString(int current) {
        int minutes = current / 60;
        int second = current % 60;
        return String.format("%02d", minutes) + ":" + String.format("%02d", second);
    }

    private int convertToInt(String times) {
        String[] minSen = times.split(":");
        int minutes = Integer.parseInt(minSen[0]) * 60;
        int second = Integer.parseInt(minSen[1]);
        return minutes + second;
    }
}
