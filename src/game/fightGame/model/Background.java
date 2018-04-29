package game.fightGame.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background implements IArea {
	private Dimension sizeOfMap;
	private Image image;

	public Background(Dimension sizeOfMap) {
		this.sizeOfMap = sizeOfMap;

		try {
			image = ImageIO.read(new File("/Pictures/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Dimension getDimension() {
		return sizeOfMap;
	}

	@Override
	public Image getImage() {
		return image;
	}

}
