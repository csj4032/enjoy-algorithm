import java.util.Arrays;
import java.util.Comparator;

public class CostEffectiveness {

	public static void main(String[] args) {

		Integer component[] = {30, 70, 15, 40, 65};
		Double maxCostEffectiveness = 0D;

		Integer price = 10;
		Integer componentPrice = 3;
		Integer performance = 150;

		Arrays.sort(component, Comparator.comparing(Integer::intValue).reversed());

		for (int i = 0; i < component.length; i++) {
			performance = performance + component[i];
			price = price + componentPrice;
			Double costEffectiveness = Double.valueOf(performance) / Double.valueOf(price);
			if (maxCostEffectiveness < costEffectiveness) {
				maxCostEffectiveness = costEffectiveness;
			}
		}

		System.out.println(maxCostEffectiveness);
	}
}