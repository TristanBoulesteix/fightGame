package game.fightGame.model;

import java.awt.Image;
import java.util.ArrayList;

public abstract class Character implements ICharacter {
	private final int ATTACK;
	private int currentLife;
	private int damagesReceived = 0;
	private ArrayList<Image> sprites;

	private boolean blocked;

	public Character(ArrayList<Image> sprites, int attack) {
		this.sprites = sprites;
		blocked = false;
		this.ATTACK = attack;
	}

	@Override
	public int attack(ICharacter target) {
		int damages = this.getATTACK();
		target.setCurrentLife(target.getCurrentLife() - this.getATTACK());

		return damages;
	}

	@Override
	public void block() {
		setBlocked(true);
	}

	@Override
	public void setReady() {
		setBlocked(false);
	}

	@Override
	public int getCurrentLife() {
		return currentLife;
	}

	@Override
	public void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
		this.setDamagesReceived(currentLife);
	}

	@Override
	public boolean isBlocked() {
		return blocked;
	}

	@Override
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
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

	@Override
	public int getATTACK() {
		return ATTACK;
	}

	public int getDamagesReceived() {
		return damagesReceived;
	}

	public void setDamagesReceived(int damagesReceived) {
		this.damagesReceived = damagesReceived;
	}

}
