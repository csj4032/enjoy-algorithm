package greedy;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GymClothesTest {

	@Test
	@Order(1)
	public void test() {
		Assertions.assertEquals(6, GymClothes.solution(7, new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 4, 5, 6, 7}));
		Assertions.assertEquals(2, GymClothes.solution(7, new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 7}));
		Assertions.assertEquals(6, GymClothes.solution(7, new int[]{2, 3, 4}, new int[]{1, 2, 3, 6}));
		Assertions.assertEquals(7, GymClothes.solution(7, new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}));
		Assertions.assertEquals(6, GymClothes.solution(7, new int[]{2, 3, 4, 5, 6, 7}, new int[]{1, 2, 3, 4, 5, 6}));
		Assertions.assertEquals(1, GymClothes.solution(2, new int[]{1, 2}, new int[]{1}));
		Assertions.assertEquals(2, GymClothes.solution(2, new int[]{1}, new int[]{1, 2}));
		Assertions.assertEquals(30, GymClothes.solution(30, new int[]{29}, new int[]{30}));
		Assertions.assertEquals(7, GymClothes.solution(8, new int[]{1, 2, 6}, new int[]{3, 4, 5}));
	}

	@Test
	@Order(2)
	public void test2() {
		Assertions.assertEquals(6, GymClothes.solution2(7, new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 4, 5, 6, 7}));
		Assertions.assertEquals(2, GymClothes.solution2(7, new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 7}));
		Assertions.assertEquals(6, GymClothes.solution2(7, new int[]{2, 3, 4}, new int[]{1, 2, 3, 6}));
		Assertions.assertEquals(7, GymClothes.solution2(7, new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6}));
		Assertions.assertEquals(6, GymClothes.solution2(7, new int[]{2, 3, 4, 5, 6, 7}, new int[]{1, 2, 3, 4, 5, 6}));
		Assertions.assertEquals(1, GymClothes.solution2(2, new int[]{1, 2}, new int[]{1}));
		Assertions.assertEquals(2, GymClothes.solution2(2, new int[]{1}, new int[]{1, 2}));
		Assertions.assertEquals(30, GymClothes.solution2(30, new int[]{29}, new int[]{30}));
		Assertions.assertEquals(7, GymClothes.solution2(8, new int[]{1, 2, 6}, new int[]{3, 4, 5}));
	}
}