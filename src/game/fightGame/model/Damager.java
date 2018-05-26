package game.fightGame.model;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Damager extends Character {
	private final static int PV = 3;
	private final static int PA = 2;

	public Damager() throws IOException {
		super(loadPictures(), PA);
		setCurrentLife(PV);
	}

	private static ArrayList<Image> loadPictures() throws IOException {
		ArrayList<Image> sprites = new ArrayList<Image>();

		Image ready = ImageIO.read(Damager.class.getResource("/Pictures/Damager_Ready.png"));
		sprites.add(ready);

		Image attacking = ImageIO.read(Damager.class.getResource("/Pictures/Damager_Attacking.png"));
		sprites.add(attacking);

		Image injuried = ImageIO.read(Damager.class.getResource("/Pictures/Damager_Injuried.png"));
		sprites.add(injuried);

		Image dead = ImageIO.read(Damager.class.getResource("/Pictures/Damager_Dead.png"));
		sprites.add(dead);

		Image blocking = ImageIO.read(Damager.class.getResource("/Pictures/Damager_Blocking.png"));
		sprites.add(blocking);

		return sprites;
	}

	@Override
	public String useSpecialPower(ICharacter target, String targetName, String executorName) {
		String text = null;

		if (getDamagesReceived() > 0) {
			target.setCurrentLife(target.getCurrentLife() - this.getATTACK());
			text = targetName + " a renvoyé " + getDamagesReceived() + "points de dégâts sur " + executorName;
		}

		return text;
	}

}
