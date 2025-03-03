package levelTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongJustPlayed {

    class Music implements Comparable<Music> {
        public int index;
        public String title;
        public String melody;
        public String start;
        public int startTime;
        public String end;
        public int endTime;
        public int time;
        public List<String> played;

        public Music(int index, String start, String end, String title, String melody) {
            this.index = index;
            this.start = start;
            this.end = end;
            this.title = title;
            this.melody = melody;
            this.startTime = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
            this.endTime = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
            this.time = endTime - startTime;
            this.played = getPlay();
        }

        private List<String> getPlay() {
            List<String> notes = matcher(melody);
            List<String> played = new ArrayList<>();
            for (int i = 0; i < time; i++) played.add(notes.get(i % notes.size()));
            return played;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "index=" + index +
                    ", title='" + title + '\'' +
                    ", melody='" + melody + '\'' +
                    ", time=" + time +
                    ", played=" + played +
                    '}';
        }

        @Override
        public int compareTo(Music o) {
            if (time == o.time) return Integer.compare(index, o.index);
            return Integer.compare(o.time, time);
        }
    }

    public String solution(String m, String[] musicinfos) {
        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            Music music = new Music(i + 1, info[0], info[1], info[2], info[3]);
            musicList.add(music);
        }
        List<String> remember = matcher(m);
        Collections.sort(musicList);
        for (Music music : musicList) {
            if (isContains(music, remember)) return music.title;
        }
        return "(None)";
    }

    private boolean isContains(Music music, List<String> remember) {
        List<String> played = music.played;
        int m = remember.size();
        int n = played.size();
        for (int i = 0; i <= n - m; i++) {
            if (played.subList(i, i + m).equals(remember)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> matcher(String melody) {
        List<String> notes = new ArrayList<>();
        String scalePattern = "C#|D#|F#|G#|A#|[A-G]";
        Pattern pattern = Pattern.compile(scalePattern);
        Matcher matcher = pattern.matcher(melody);
        while (matcher.find()) notes.add(matcher.group());
        return notes;
    }
}
