package projet.model;

public class Score {
	private static int actScore = 0;

	public static int getActScore() {
		return actScore;
	}

	public static void setActScore(int actScore) {
		Score.actScore = actScore;
	}
	
}
