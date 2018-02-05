package woowaBrothers.p2018;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2 {

	public static void main(String[] args) {
		System.out.println(solution("photo.jpg, Warsaw, 2013-09-05 11:08:15\nphoto.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11"));
	}

	private static String solution(String S) {
		String[] files = S.split("\n");
		int length = files.length;
		List<Photo> photos = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < length; i++) {
			String[] units = files[i].split("\\s*(=>|,)\\s*");
			String[] fileNameExtention = units[0].split("\\.");
			Photo photo = new Photo(fileNameExtention[0], fileNameExtention[1], units[1], LocalDateTime.parse(units[2], formatter));
			photos.add(photo);
		}

		Map<String, List<Photo>> map = photos.stream().collect(Collectors.groupingBy(e -> e.getCityName()));
		map.entrySet().stream().forEach(e -> e.getValue().sort(Comparator.comparing(Photo::getDateTime)));

		int photoSize = photos.size();
		for (int i = 0; i < photoSize; i++) {
			Photo photo = photos.get(i);
			List<Photo> p = map.get(photo.getCityName());
			int size = p.size();
			int decimal = getDecimal(size);
			String number = "";
			for (int j = 0; j < size; j++) {
				if (p.get(j).getCityNameDateTime().equals(photo.getCityNameDateTime())) {
					if (decimal > 1) {
						number = String.format("%0" + decimal + "d", j + 1);
					} else {
						number = String.valueOf(j + 1);
					}
				}
			}
			sb.append(photo.getCityName() + number + "." + photo.getExtension()).append((photoSize == i) ? "" : "\n");
		}

		return sb.toString();
	}

	private static int getDecimal(int size) {
		int i = 0;
		while (size > 0) {
			i++;
			size = size / 10;
		}
		return i;
	}
}

class Photo {
	String photoName;
	String extension;
	String cityName;
	LocalDateTime dateTime;

	public Photo(String photoName, String extension, String cityName, LocalDateTime dateTime) {
		this.photoName = photoName;
		this.extension = extension;
		this.cityName = cityName;
		this.dateTime = dateTime;
	}

	public String getCityName() {
		return cityName;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getExtension() {
		return extension;
	}

	public String getCityNameDateTime() {
		return cityName + dateTime;
	}
}