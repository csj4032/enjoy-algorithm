package kakaoBlindRecuitment2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class OpenChatRoomTest {

	public String[] solution(String[] record) {
		OpenChatRoom openChatRoom = new OpenChatRoom();
		openChatRoom.recording(record);
		return openChatRoom.getResult();
	}


	@Test
	public void test() {
		String[] result = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
		System.out.println(Arrays.toString(result));
		Assertions.assertArrayEquals(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}, result);
	}
}