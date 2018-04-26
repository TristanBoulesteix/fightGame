package game.fightGame.model;

public class Character implements ICharacter {
	private int currentLife;
	private boolean blocked;

	public Character() {
		blocked = false;
	}

	@Override
	public void attack() {

	}

	@Override
	public void block() {
		setBlocked();
	}

	@Override
	public void useSpecialPower() {

	}

	@Override
	public int getCurrentLife() {
		return currentLife;
	}

	@Override
	public void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}

	@Override
	public boolean isBlocked() {
		return blocked;
	}

	@Override
	public void setBlocked() {
		this.blocked = true;
	}

}
