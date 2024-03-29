package kakaoBlindRecuitment2019;

public class FailureRate implements Comparable<FailureRate> {

	private int number;
	private Stage stage;
	private int totalChallenger;

	public FailureRate(int number, Stage stage, int totalChallenger) {
		this.number = number;
		this.stage = stage;
		if (this.stage == null) {
			this.stage = new Stage(number, 0);
		}
		this.totalChallenger = totalChallenger;
	}

	public int getNumber() {
		return number;
	}

	public int getChallenger() {
		return stage.getChallenger();
	}

	public Double getRate() {
		return (double) stage.getChallenger() / totalChallenger;
	}

	@Override
	public int compareTo(FailureRate o) {
		return o.getRate().compareTo(this.getRate());
	}

	@Override
	public String toString() {
		return "FailureRate{" +
				"number=" + number +
				", stage=" + stage +
				", totalChallenger=" + totalChallenger +
				", rate=" + getRate() +
				'}';
	}
}


class Stage {

	private int number;
	private int challenger;

	public Stage(int number, int challenger) {
		this.number = number;
		this.challenger = challenger;
	}

	public int getNumber() {
		return number;
	}

	public int getChallenger() {
		return challenger;
	}

	public int increaseChallenger() {
		return challenger++;
	}

	@Override
	public String toString() {
		return "Stage{" +
				"number=" + number +
				", challenger=" + challenger +
				'}';
	}
}