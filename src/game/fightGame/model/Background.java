package game.fightGame.model;

import java.awt.Image;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

public class Background implements IArea {
	private final int NUMBER_OF_EXISTING_PICTURES = 3;

	private Image desert, forest, mountain;

	public Background() {
		try {
			desert = ImageIO.read(getClass().getResource("/Background_image/desert.jpg"));
			forest = ImageIO.read(getClass().getResource("/Background_image/forest.jpg"));
			mountain = ImageIO.read(getClass().getResource("/Background_image/mountain.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Image getRandomBackgroungImage() {
		Image image;

		int rand = ThreadLocalRandom.current().nextInt(1, 3 + 1);

		System.out.println(rand);

		switch (rand) {
		case 1:
			image = desert;
			break;

		case 2:
			image = forest;
			break;

		case 3:
			image = mountain;
			break;

		default:
			image = mountain;
			break;
		}

		return image;
	}

}
