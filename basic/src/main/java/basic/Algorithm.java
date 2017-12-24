package basic;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class Algorithm {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		for (int i = 1; i < 10; i++) {
//			out.printf("%d * %d = %d \n", n, i, i * n);
//		}

//		ProcessHandle self = ProcessHandle.current();
//		long PID = self.getPid();
//		ProcessHandle.Info procInfo = self.info();
//
//		Optional<String[]> arguments = procInfo.arguments();
//		Optional<String> cmd = procInfo.commandLine();
//		Optional<Instant> startTime = procInfo.startInstant();
//		Optional<Duration> cpuUsage = procInfo.totalCpuDuration();
//
//		//System.out.println(Arrays.toString(arguments.get()));
//		System.out.println(cmd);
//		System.out.println(startTime);
//		System.out.println(cpuUsage);

		Integer[] d = new Integer[]{0, 1};
		//System.out.println(Arrays.asList(d).stream().allMatch(b -> b == 0));

		String s = "";
		nonnull(s);

//
//		BitSet bits1 = new BitSet(16);
//		BitSet bits2 = new BitSet(16);
//
//
//		bits1.set(0,3);
//		bits2.set(2);
//
//
//		System.out.println(bits1);
//		System.out.println(bits2);
//
//		bits1.xor(bits2);
//
//		System.out.println(bits1);
//
//		bits1.or(bits2);
//
//		System.out.println(bits1);


//		BigInteger bi = BigInteger.probablePrime(5, new Random(100));
//		System.out.println(bi);


		//http://gocoding.tistory.com/93
		//Pattern p = Pattern.compile("^([a-z])(?=.*\\d).{4,16}$");
		Pattern p = Pattern.compile("^(\\S)(?=.*\\d)(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{4,16}$");
		Matcher m = p.matcher("aaaa#dd1>1");

		while (m.find()) {
			System.out.println(m.group(0));
		}

		System.out.println(Arrays.stream(new Integer[]{1, 23, 4, 9, 62}).map(String::valueOf).collect(joining()));
	}


	public static String nonnull(@Nonnull String s) {
		return s;
	}


	private static int solution3(String S) {
		//return Arrays.stream(S.split("[0-9]+")).filter(s -> s.matches(".*[A-Z].*")).max(Comparator.comparing(String::length)).map(String::length).orElse(-1);
		return Arrays.stream(S.split("[0-9]+")).filter(s -> s.matches(".*[A-Z].*")).map(String::length).max(Comparator.comparing(Integer::valueOf)).orElse(-1);
	}
}