import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Synapsoft {

	private static final String input = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";

	public static void main(String[] args) {
		String[] names = input.split(",");
		//System.out.println("김씨 = " + Arrays.asList(names).stream().filter(i -> i.startsWith("김")).count());
		//System.out.println("이씨 = " + Arrays.asList(names).stream().filter(i -> i.startsWith("이")).count());
		System.out.println(Arrays.asList(names).stream().collect(Collectors.groupingBy(p -> p.charAt(0), Collectors.counting())).entrySet().stream().filter(k->k.getKey().equals('김') || k.getKey().equals('이')).collect(toSet()));
		System.out.println(new LinkedHashSet(new ArrayList(Arrays.asList(names))).stream().map(i-> {System.out.println(i); return i;}).sorted().collect(toList()));
		//System.out.println(new LinkedHashSet<String>(new ArrayList<String>(Arrays.asList(names)).stream().sorted().collect(toList())));
	}
}
