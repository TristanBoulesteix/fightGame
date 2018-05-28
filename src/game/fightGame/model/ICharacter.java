package game.fightGame.model;

import java.awt.Image;

public interface ICharacter {
	public int attack(ICharacter target);

	public void block();

	public String useSpecialPower(ICharacter target, String targetName, String executorName);

	public void setReady();

	public int getCurrentLife();

	public void setCurrentLife(int currentLife);

	public boolean isBlocked();

	public void setBlocked(boolean blocked);

	public Image getSprite(int index);

	public int getATTACK();
}
