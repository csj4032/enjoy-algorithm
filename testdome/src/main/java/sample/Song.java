package sample;

import java.util.HashSet;
import java.util.Set;

public class Song {
	private String name;
	private Song nextSong;

	public Song(String name) {
		this.name = name;
	}

	public void setNextSong(Song nextSong) {
		this.nextSong = nextSong;
	}

	public boolean isRepeatingPlaylist() {
		Song next = this.nextSong;
		Set<String> songSet = new HashSet<>();
		while (next != null) {
			if (songSet.contains(next.name)) {
				return true;
			} else {
				songSet.add(next.name);
				next = next.nextSong;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Song first = new Song("Hello");
		Song second = new Song("Eye of the tiger");
		Song second1 = new Song("Eye of the tiger3");
		first.setNextSong(second);
		second.setNextSong(second1);
		second1.setNextSong(second);
		System.out.println(first.isRepeatingPlaylist());
	}
}
