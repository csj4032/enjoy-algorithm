package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {
        List<Song> songs = new ArrayList<>();
        Map<String, Genre> genreMap = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            Genre genre = genreMap.computeIfAbsent(genres[i], (k) -> new Genre(k, 0));
            genre.setPlays(plays[i]);
            songs.add(new Song(genre, plays[i], i));
        }

        return songs.stream()
                .sorted(comparing(Song::getGenrePlays).thenComparing(comparing(Song::getPlays).reversed()))
                .collect(Collectors.groupingBy(e -> e.getGenre(), () -> new TreeMap<>((o1, o2) -> o2.plays.compareTo(o1.plays)), Collectors.toList()))
                .entrySet()
                .stream()
                .flatMap(e -> e.getValue().stream().limit(2))
                .mapToInt(e -> e.getId()).toArray();
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

    public Integer getId() {
        return id;
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