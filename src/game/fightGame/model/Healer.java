package game.fightGame.model;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Healer extends Character {
	private final static int PV = 4;
	private final static int PA = 1;

	public Healer() throws IOException {
		super(loadPictures());
		setCurrentLife(PV);
	}

	private static ArrayList<Image> loadPictures() throws IOException {
		ArrayList<Image> sprites = new ArrayList<Image>();

		Image ready = ImageIO.read(Healer.class.getResource("/Pictures/Healer_Ready.png"));
		sprites.add(ready);

		Image attacking = ImageIO.read(Healer.class.getResource("/Pictures/Healer_Attacking.png"));
		sprites.add(attacking);

		Image injuried = ImageIO.read(Healer.class.getResource("/Pictures/Healer_Injuried.png"));
		sprites.add(injuried);

		Image dead = ImageIO.read(Healer.class.getResource("/Pictures/Healer_Dead.png"));
		sprites.add(dead);

		Image blocking = ImageIO.read(Healer.class.getResource("/Pictures/Healer_Blocking.png"));
		sprites.add(blocking);

		return sprites;
	}

}
