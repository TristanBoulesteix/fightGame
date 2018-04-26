package game.fightGame.model;

public class Tank extends Character {
	private final static int PV = 5;
	private final static int PA = 1;
	private final static String NAME = "Tank";

	public Tank() {
		super();
		setCurrentLife(PV);
	}

}
