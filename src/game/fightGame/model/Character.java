package game.fightGame.model;

import java.awt.Image;
import java.util.ArrayList;

public class Character implements ICharacter {
	private int currentLife;
	private ArrayList<Image> sprites;

	private boolean blocked;

	public Character(ArrayList<Image> sprites) {
		this.sprites = sprites;
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

	@Override
	public Image getSprite(int index) {
		Image sprite = null;

		for (int i = 0; i < sprites.size(); i++) {
			if (index == i) {
				sprite = sprites.get(i);
			}
		}

		return sprite;
	}

}
