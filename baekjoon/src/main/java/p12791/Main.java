package p12791;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Album> albumList = new ArrayList<>();

	static {
		albumList.add(new Album(1967, "DavidBowie"));
		albumList.add(new Album(1969, "SpaceOddity"));
		albumList.add(new Album(1970, "TheManWhoSoldTheWorld"));
		albumList.add(new Album(1971, "HunkyDory"));
		albumList.add(new Album(1972, "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars"));
		albumList.add(new Album(1973, "AladdinSane"));
		albumList.add(new Album(1973, "PinUps"));
		albumList.add(new Album(1974, "DiamondDogs"));
		albumList.add(new Album(1975, "YoungAmericans"));
		albumList.add(new Album(1976, "StationToStation"));
		albumList.add(new Album(1977, "Low"));
		albumList.add(new Album(1977, "Heroes"));
		albumList.add(new Album(1979, "Lodger"));
		albumList.add(new Album(1980, "ScaryMonstersAndSuperCreeps"));
		albumList.add(new Album(1983, "LetsDance"));
		albumList.add(new Album(1984, "Tonight"));
		albumList.add(new Album(1987, "NeverLetMeDown"));
		albumList.add(new Album(1993, "BlackTieWhiteNoise"));
		albumList.add(new Album(1995, "1.Outside"));
		albumList.add(new Album(1997, "Earthling"));
		albumList.add(new Album(1999, "Hours"));
		albumList.add(new Album(2002, "Heathen"));
		albumList.add(new Album(2003, "Reality"));
		albumList.add(new Album(2013, "TheNextDay"));
		albumList.add(new Album(2016, "BlackStar"));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			StringBuilder tsb = new StringBuilder();
			long count = albumList.stream().filter(e -> e.isContain(sc.nextInt(), sc.nextInt())).map(e -> tsb.append(e.toString()).append("\n")).count();
			sb.append(count).append("\n");
			sb.append(tsb.toString());
		}
		System.out.println(sb.toString());
	}
}

class Album {
	int year;
	String title;

	public Album(int year, String title) {
		this.year = year;
		this.title = title;
	}

	public boolean isContain(int from, int to) {
		return year >= from && year <= to;
	}

	public String toString() {
		return year + " " + title;
	}
}
