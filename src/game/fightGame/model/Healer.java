package game.fightGame.model;

public class Healer extends Character {
	private final static int PV = 4;
	private final static int PA = 1;
	private final static String NAME = "Healer";

	public Healer() {
		super();
		setCurrentLife(PV);
	}

}
