package kakaoBlindRecuitment2019;

import java.util.*;

public class OpenChatRoom {

	private List<Event> events;
	private Map<String, User> uuids;

	public OpenChatRoom() {
		this.events = new ArrayList<>();
		this.uuids = new HashMap<>();
	}

	public void recording(String[] record) {
		for (int i = 0; i < record.length; i++) {
			String[] entity = parse(record[i]);
			events.add(new Event(i, findUser(entity[1]), entity));
		}
	}

	public String[] getResult() {
		return events.stream().filter(e -> e.isDisplay()).map(e -> e.getMessage()).toArray(String[]::new);
	}

	private String[] parse(String s) {
		return s.split(" ");
	}

	private User findUser(String uid) {
		return uuids.computeIfAbsent(uid, (u) -> new User(u));
	}
}

class Event {

	private Integer eid;
	private Action action;
	private User user;

	public Event(Integer eid, User user, String[] entity) {
		this.eid = eid;
		this.user = user;
		this.action = Action.valueOf(entity[0]);
		if (action.isRequireNickName()) this.user.setNickName(entity[2]);
	}

	public boolean isDisplay() {
		return this.action.isDisplay();
	}

	public String getMessage() {
		return user.getNickName() + action.getMessage();
	}
}

/*
 * Display 관련 객체를 만들것인가?
 * */
enum Action {
	Enter(true, true, "님이 들어왔습니다."),
	Leave(true, false, "님이 나갔습니다."),
	Change(false, true, "님이 닉네임을 변경하였습니다.");

	private boolean isDisplay;
	private boolean requireNickName;
	private String message;

	Action(boolean isDisplay, boolean requireNickName, String message) {
		this.isDisplay = isDisplay;
		this.requireNickName = requireNickName;
		this.message = message;
	}

	public boolean isDisplay() {
		return isDisplay;
	}

	public boolean isRequireNickName() {
		return requireNickName;
	}

	public String getMessage() {
		return message;
	}
}

class User {

	private String uid;
	private String nickName;

	public User(String uid) {
		this.uid = uid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}