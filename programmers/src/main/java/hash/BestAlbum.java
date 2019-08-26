package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class BestAlbum {

    private static String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
    private static Integer[] plays = new Integer[]{500, 600, 150, 800, 2500};
    private static Map<String, Genre> generMap = new HashMap<>();

    public static void main(String[] args) {
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final Integer play = plays[i];
            Genre genre = generMap.computeIfAbsent(genres[i], (k) -> new Genre(k, 0));
            genre.setPlays(play);
            songs.add(new Song(genre, plays[i], i));
        }

        List<Song> songsTopTowByGenre = songs.stream()
                .sorted(comparing(Song::getGenrePlays).thenComparing(comparing(Song::getPlays).reversed()))
                .collect(Collectors.groupingBy(e -> e.getGenre(), () -> new TreeMap<>((o1, o2) -> o2.plays.compareTo(o1.plays)), Collectors.toList()))
                .entrySet()
                .stream()
                .flatMap(e -> e.getValue().stream().limit(2))
                .collect(Collectors.toList());
        System.out.println(songsTopTowByGenre);
    }
}

class Genre {
    String name;
    Integer plays;

    public Genre(String name, Integer plays) {
        this.name = name;
        this.plays = plays;
    }

    public void setPlays(Integer play) {
        plays += play;
    }

    public Integer getPlays() {
        return plays;
    }
}

class Song {
    private Integer id;
    private Genre genre;
    Integer plays;

    public Song(Genre genre, Integer plays, Integer id) {
        this.id = id;
        this.plays = plays;
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public Integer getGenrePlays() {
        return genre.getPlays();
    }

    public Integer getPlays() {
        return plays;
    }
}
