import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.Scanner;

public class FileSort {

	public static void main(String[] args) throws FileNotFoundException {
		String path = FileSort.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "FileSort.txt"));
		PrintWriter pw = new PrintWriter(new File( "FileSortResult.txt"));
		BitSet bs = new BitSet(10000000);

		while (sc.hasNext()) {
			bs.set(sc.nextInt(), true);
		}

		sc.close();

		bs.stream().forEach(b -> {
			pw.println(b);
		});

		pw.close();
	}
}