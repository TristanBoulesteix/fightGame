package game.fightGame.view.gameFrame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class GameArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8507586720885351704L;

	private Image background;

	public GameArea() {
		super();
	}

	public void addBackground(Image background) {
		this.background = background;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, null);
	}
}
