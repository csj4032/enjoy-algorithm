package levelTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortFileNames {

	public String[] solution(String[] files) {
		int length = files.length;
		List<File> list = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			File file = new File(files[i], i);
			list.add(file);
		}
		Collections.sort(list);
		String[] answer = list.stream().map(e -> e.getFileName()).toArray(String[]::new);
		return answer;
	}
}

class File implements Comparable<File> {

	private String head;
	private Integer number;
	private String tail;
	private String fileName;
	private Integer index;

	private static Pattern pattern = Pattern.compile("([A-Za-z\\-\\.\\s]*)(\\d{1,5})([\\dA-Za-z\\-\\.\\s])?");

	public File(String fileName, Integer index) {
		this.fileName = fileName;
		this.index = index;
		Matcher matcher = pattern.matcher(fileName);
		if (matcher.find()) {
			head = matcher.group(1);
			number = Integer.valueOf(matcher.group(2));
			tail = matcher.group(3);
		}
	}

	public String getHead() {
		return head;
	}

	public Integer getNumber() {
		return number;
	}

	public String getFileName() {
		return fileName;
	}

	public Integer getIndex() {
		return index;
	}

	@Override
	public int compareTo(File o) {
		int head = this.getHead().toLowerCase().compareTo(o.getHead().toLowerCase());
		if (head != 0) return head;
		int number = this.getNumber().compareTo(o.getNumber());
		if (number != 0) return number;
		int index = this.getIndex().compareTo(o.getIndex());
		return index;
	}

	@Override
	public String toString() {
		return "File{" +
				"head='" + head + '\'' +
				", number=" + number +
				", tail='" + tail + '\'' +
				", fileName='" + fileName + '\'' +
				", index=" + index +
				'}';
	}
}
