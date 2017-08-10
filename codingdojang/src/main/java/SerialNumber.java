import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class SerialNumber {

	public static void main(String[] args) throws ScriptException {

		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		String[] b = {"+", "-", " "};
		List<String> c = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						for (int m = 0; m < 3; m++) {
							for (int n = 0; n < 3; n++) {
								for (int o = 0; o < 3; o++) {
									for (int p = 0; p < 3; p++) {
										String d = b[p] + b[o] + b[n] + b[m] + b[l] + b[k] + b[j] + b[i];
										c.add(d);
									}
								}
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < 6561; i++) {
			String[] f = c.get(i).split("");
			String q = "";
			for (int j = 0; j < 8; j++) {
				q += a[j] + f[j];
			}
			q += a[8];
			String t = q.toString().replaceAll(" ", "");
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			if ((Integer) engine.eval(t) == 100) {
				System.out.println(t);
			}
		}
	}
}