package game.fightGame.model;

import java.awt.Color;

public class Background implements IArea {
	private Dimension sizeOfMap;
	private Color color;

	public Background(Dimension sizeOfMap, Color color) {
		this.sizeOfMap = sizeOfMap;
		this.color = color;
	}

	@Override
	public Dimension getDimension() {
		return sizeOfMap;
	}

	@Override
	public Color getColor() {
		return color;
	}

}
