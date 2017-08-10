import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AustralianVoting {

	public static void main(String[] args) throws FileNotFoundException {
		String path = AustralianVoting.class.getResource("").getPath();
		Scanner sc = new Scanner(new File(path + "/AustralianVoting.txt"));

		int n = Integer.valueOf(sc.nextLine());
		String[] v = new String[n];
		List<Stack<Integer>> nn = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			v[i] = sc.nextLine();
		}

		int k = 0;
		while (sc.hasNextLine()) {
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < n; i++) {
				stack.add(sc.nextInt());
			}
			nn.add(stack);
			k++;
		}

		int l = nn.size();

		for (int i = 0; i < n; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < l; j++) {
				list.add(nn.get(j).get(0));
			}
			Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			Optional<Map.Entry<Integer, Long>> max = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));

			Long maxVotedCount = max.get().getValue();

			if (maxVotedCount >= ((float) k / 2)) {
				map.entrySet().stream().forEach(m -> {
					if (m.getValue().equals(maxVotedCount)) {
						System.out.println(v[m.getKey() - 1]);
					}
				});
				break;
			}

			Optional<Map.Entry<Integer, Long>> min = map.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
			Integer minVoted = min.get().getKey();
			nn.stream().forEach(e -> {
				if (e.get(0).equals(minVoted)) e.remove(0);
			});
		}
	}
}
