package p1000;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 제목 : A+B
 * 링크 : https://www.acmicpc.net/problem/1000
 * 단계 : 입/출력 받아보기
 * 분류 : 사칙연산, 수학
 */
interface Coder {
	default void coding() {
		System.out.println("Da da da");
	}
}

interface Developer {
	default void develop() {
		System.out.println("Mmm,,,");
	}
}

interface Dummy {
	Object f(Object o);
}

public class Main {
	public static void main(String[] args) {
		Iterator<?> iterator = getIteratorByType(1, List.of("One", "Two")::iterator, List.of(1, 2)::iterator, null);
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		with((Dummy & Coder & Developer) i -> i, genius -> {
			genius.coding();
			genius.develop();
		});

		var string = "String";
		string.lines();
	}

	private static <T extends Dummy> void with(T t, Consumer<T> consumer) {
		consumer.accept(t);
	}

	private static <A, B, C> Iterator<?> getIteratorByType(int type, Iterable<A> f1, Iterable<B> f2, Iterable<C> f3) {
		return switch (type) {
			case 1, 2, 3:
				yield f2.iterator();
			case 4, 5:
				yield f3.iterator();
			default:
				yield f1.iterator();
		};
	}
}