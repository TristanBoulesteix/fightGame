package game.fightGame.model;

import java.awt.Image;

public interface ICharacter {
	public void attack();

	public void block();

	public void useSpecialPower();

	public int getCurrentLife();

	public void setCurrentLife(int currentLife);

	public boolean isBlocked();

	void setBlocked();

	public Image getSprite(int index);
}
