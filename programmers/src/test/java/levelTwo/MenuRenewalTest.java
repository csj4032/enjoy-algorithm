package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuRenewalTest {

	@Test
	void test() {
		MenuRenewal menuRenewal = new MenuRenewal();
		//Assertions.assertArrayEquals(new String[]{"AC", "ACDE", "BCFG", "CDE"}, menuRenewal.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}));
		//Assertions.assertArrayEquals(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"}, menuRenewal.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}));
		Assertions.assertArrayEquals(new String[]{"WX", "XY"}, menuRenewal.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}));
	}
}