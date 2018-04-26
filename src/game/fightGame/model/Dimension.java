package game.fightGame.model;

public class Dimension {
	private int height;
	private int width;

	public Dimension(int height, int width) {
		setHeight(height);
		setWidth(width);
	}

	public Dimension(Dimension dimension) {
		setHeight(dimension.getHeight());
		setWidth(dimension.getWidth());
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
