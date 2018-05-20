package game.fightGame.view.gameFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.fightGame.model.ICharacter;

public class GameArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8507586720885351704L;

	private Image background;

	private JLabel[][] grid;

	public GameArea() {
		super();
		this.setLayout(new GridBagLayout());
		this.addGridWithLabel();
	}

	public void addGridWithLabel() {
		grid = new JLabel[6][18];

		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 18; y++) {
				JLabel label = new JLabel((Icon) null, JLabel.CENTER);
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK));

				GridBagConstraints cGridConstraints = new GridBagConstraints();
				cGridConstraints.gridx = x;
				cGridConstraints.gridy = y;
				cGridConstraints.weightx = 200;
				cGridConstraints.weighty = 200;
				cGridConstraints.fill = GridBagConstraints.BOTH;

				this.add(label, cGridConstraints);

				grid[x][y] = label;
			}
		}
	}

	public void addBackground(Image background) {
		this.background = background;
		this.repaint();
	}

	public void addCharacterOnScreen(ICharacter playerCharacter, ICharacter AICharacter) {
		JLabel playerLabel = grid[1][9];
		playerLabel.setIcon(new ImageIcon(playerCharacter.getSprite(0)));
		playerLabel.setSize(500, 500);

		JLabel AILabel = grid[4][9];
		AILabel.setIcon(new ImageIcon(AICharacter.getSprite(0)));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH), 0, 0, null);
	}
}
