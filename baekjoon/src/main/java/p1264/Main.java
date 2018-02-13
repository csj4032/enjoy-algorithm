package p1264;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String s = sc.readLine();
			if (s.equals("#")) break;
			int k = 0;
			Matcher m = Pattern.compile("(a|e|i|o|u)").matcher(s.toLowerCase());
			while (m.find()) k++;
			br.append(k+"\n");
		}
		br.flush();
	}
}