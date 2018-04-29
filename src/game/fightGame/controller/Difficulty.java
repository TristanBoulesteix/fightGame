package game.fightGame.controller;

public enum Difficulty {
	RANDOM("Al�atoire"), EASY("Facile"), HARD("Difficile");

	private String difficulty;

	private Difficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		return this.difficulty;
	}
}
