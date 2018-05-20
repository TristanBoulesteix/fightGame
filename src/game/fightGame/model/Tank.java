package game.fightGame.model;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Tank extends Character {
	private final static int PV = 5;
	private final static int PA = 1;

	public Tank() throws IOException {
		super(loadPictures());
		setCurrentLife(PV);
	}

	private static ArrayList<Image> loadPictures() throws IOException {
		ArrayList<Image> sprites = new ArrayList<Image>();

		Image ready = ImageIO.read(Tank.class.getResource("/Pictures/Tank_Ready.png"));
		sprites.add(ready);

		Image attacking = ImageIO.read(Tank.class.getResource("/Pictures/Tank_Attacking.png"));
		sprites.add(attacking);

		Image injuried = ImageIO.read(Tank.class.getResource("/Pictures/Tank_Injuried.png"));
		sprites.add(injuried);

		Image dead = ImageIO.read(Tank.class.getResource("/Pictures/Tank_Dead.png"));
		sprites.add(dead);

		Image blocking = ImageIO.read(Tank.class.getResource("/Pictures/Tank_Blocking.png"));
		sprites.add(blocking);

		return sprites;
	}

}
